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
public class ThreadPoolQueueTest {

    private static BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
    private static ExecutorService executePool = new ThreadPoolExecutor(2, 4,
            3L, TimeUnit.SECONDS, blockingQueue);


    public static void main(String[] args) {
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());
        executePool.submit(new MyThread());
        log.info("任务队列长度:{}", blockingQueue.size());

        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            log.info("任务队列长度:{}", blockingQueue.size());
        }
    }


    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.run();
        }
    }
}
