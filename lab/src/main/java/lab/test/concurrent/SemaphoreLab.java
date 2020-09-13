package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量 实验
 *
 * @author jasonsong
 * 2020/9/13
 */

@Slf4j
public class SemaphoreLab {
    static Semaphore semaphore = new Semaphore(2);
    private static BlockingQueue blockingQueue = new LinkedBlockingQueue<>(10);
    private static int availableProcessors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executePool = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2,
            1, TimeUnit.SECONDS, blockingQueue);


    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(availableProcessors);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> log.info("workQueueLength:{} ,blockingQueue size:{} ", semaphore.getQueueLength(), blockingQueue.size()),
                0, 500, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 7; i++) {
            executePool.submit(new MyThread(i));
            Thread.sleep(10);
        }

        log.info("semaphore.availablePermits() : {}", semaphore.availablePermits());
        Thread.sleep(7000);
        scheduledThreadPoolExecutor.shutdown();
        log.info("semaphore.availablePermits() : {}", semaphore.availablePermits());

    }

    static class MyThread extends Thread {
        int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                log.info("im running:{}", i);
                Thread.sleep(1000);
                log.info("i'll quit:{}", i);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            semaphore.release();
        }
    }

}
