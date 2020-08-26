package lab.test.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jasonsong
 * 2018/11/23
 */


public class AtomicLab {
    private static final int LOOP_TIME = 500;
    private static final Object LOCK = new Object();
    private static Integer availableProcessors = Runtime.getRuntime().availableProcessors();
    private static Lock lock = new ReentrantLock();

    private static Integer i0 = 0;
    private static Integer i01 = 0;
    private static volatile Integer i1 = 0;
    private static Integer i2 = 0;
    private static AtomicInteger i3 = new AtomicInteger();
    private static Integer i4 = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("jasonLab-%d").build();
        ExecutorService service = new ThreadPoolExecutor(LOOP_TIME, LOOP_TIME,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5000), threadFactory);
        for (int i = 0; i < 1000; i++) {
            service.execute(new TestThread0());
            service.execute(new TestThread01());
            service.execute(new TestThread1());
            service.execute(new TestThread2());
            service.execute(new TestThread3());
            service.execute(new TestThread4());
        }
        Thread.sleep(1000L);
        System.out.println("i0 result is " + i0 + " , equal 50000 : " + (i0 == 500000));
        //        i0 result is 489711 , equal 50000 : false
        System.out.println("i01 result is " + i01 + " , equal 50000 : " + (i01 == 500000));
        //        i01 result is 489010 , equal 50000 : false
        System.out.println("i1 result is " + i1 + " , equal 50000 : " + (i1 == 500000));
        //        i1 result is 489456 , equal 50000 : false
        System.out.println("i2 result is " + i2 + " , equal 50000 : " + (i2 == 500000));
        //        i2 result is 500000 , equal 50000 : true
        System.out.println("i3 result is " + i3 + " , equal 50000 : " + (i3.get() == 500000));
        //        i3 result is 500000 , equal 50000 : true
        System.out.println("i4 result is " + i4 + " , equal 50000 : " + (i4 == 500000));
        //        i4 result is 500000 , equal 50000 : true

        service.shutdown();
    }

    static class TestThread0 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIME; i++) {
                i0 += 1;
            }
        }
    }

    static class TestThread01 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIME; i++) {
                i01++;
            }
        }
    }

    static class TestThread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIME; i++) {
                i1++;
            }
        }
    }

    static class TestThread2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIME; i++) {
                synchronized (LOCK) {
                    i2 += 1;
                }
            }
        }
    }

    static class TestThread3 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < LOOP_TIME; i++) {
                i3.getAndAdd(1);
            }
        }
    }

    static class TestThread4 implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < LOOP_TIME; i++) {
                    i4++;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
