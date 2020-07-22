package lab.test.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author jasonsong
 * 2020/4/25
 */


public class CountDownLatchTest {

    private static Integer availableProcessors = Runtime.getRuntime().availableProcessors();
    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("jasonLab-%d").build();
    private static ExecutorService executor = new ThreadPoolExecutor(availableProcessors + 1, availableProcessors * 2,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), threadFactory);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);


        executor.execute(new Thread1(countDownLatch));
        Thread.sleep(500);
        executor.execute(new Thread2(countDownLatch));
        Thread.sleep(500);
        executor.execute(new Thread2(countDownLatch));
        Thread.sleep(500);
        executor.execute(new Thread2(countDownLatch));
        Thread.sleep(500);
        executor.execute(new Thread2(countDownLatch));
        Thread.sleep(500);
        executor.execute(new Thread2(countDownLatch));

    }


    static class Thread1 implements Runnable {
        private CountDownLatch countDownLatch;

        public Thread1(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            int n = 10;
            while (n >= 0) {
                System.out.println("Thread1");
                if (--n == 8) {
                    try {
                        System.out.println("countDownLatch.await()");
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Thread2 implements Runnable {
        private CountDownLatch countDownLatch;

        public Thread2(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("other thread");
            long count = countDownLatch.getCount();
            if (count > 0) {
                System.out.println("countDownLatch.countDown(). count :"+count);
                countDownLatch.countDown();
            }
        }
    }


}
