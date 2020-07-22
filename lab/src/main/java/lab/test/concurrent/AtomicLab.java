package lab.test.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
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
    private static volatile Integer i1 = 0;
    private static Integer i2 = 0;
    private static AtomicInteger i3 = new AtomicInteger();
    private static Integer i4 = 0;

    public static void main(String[] args) throws InterruptedException {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("jasonLab-%d").build();
        ExecutorService service = new ThreadPoolExecutor(availableProcessors + 1, availableProcessors * 2,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5000), threadFactory);
        for (int i = 0; i < 100; i++) {
            service.execute(new TestThread0());
            service.execute(new TestThread1());
            service.execute(new TestThread2());
            service.execute(new TestThread3());
            service.execute(new TestThread4());
        }
        Thread.sleep(1000L);
        System.out.println("i0 result is " + i0 + " , equal 50000 : " + (i0 == 50000));
        System.out.println("i1 result is " + i1 + " , equal 50000 : " + (i1 == 50000));
        System.out.println("i2 result is " + i2 + " , equal 50000 : " + (i2 == 50000));
        System.out.println("i3 result is " + i3 + " , equal 50000 : " + (i3.get() == 50000));
        System.out.println("i4 result is " + i4 + " , equal 50000 : " + (i4 == 50000));

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
