package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jasonsong
 * 2020/7/2
 */

@Slf4j
public class ThreadPoolLab {

    private static BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
    private static ExecutorService executePool = new ThreadPoolExecutor(2, 4,
            1, TimeUnit.SECONDS, blockingQueue);


    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread("thread1");
        MyThread thread2 = new MyThread("thread2");
        executePool.submit(thread1);
        executePool.submit(thread2);

//        Thread.sleep(5*1000);
//        System.out.println("executePool is null");
//        executePool=null;
//        Thread.sleep(5 * 1000);
//        System.out.println("System.gc();");
//        System.gc();
        Thread.sleep(10 * 1000);
        System.out.println("executePool.shutdown()");
//        executePool.shutdownNow();
        executePool.shutdown();
        Thread.sleep(30 * 1000);
    }


    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
            super.setName(name);
        }

        @Override
        public void run() {
            try {
                int i = 0;
                while (i++ < 5) {
                    System.out.println(name + "is running");
                    Thread.sleep(1 * 1000);
                }
                System.out.println(name + "is stop");
                Thread.interrupted();
//                Thread.currentThread().stop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
