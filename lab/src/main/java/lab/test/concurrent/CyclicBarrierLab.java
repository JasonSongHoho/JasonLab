package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jasonsong
 * 2020/9/13
 */

@Slf4j
public class CyclicBarrierLab {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    private static BlockingQueue blockingQueue = new LinkedBlockingQueue<>(10);
    private static int availableProcessors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService executePool = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2,
            1, TimeUnit.SECONDS, blockingQueue);


    //输出结果：
    //14:25:48.327 [pool-1-thread-1] INFO lab.test.concurrent.CyclicBarrierLab - 0
    //14:25:48.327 [pool-1-thread-2] INFO lab.test.concurrent.CyclicBarrierLab - 1
    //14:25:49.335 [pool-1-thread-3] INFO lab.test.concurrent.CyclicBarrierLab - 2
    //14:25:49.335 [pool-1-thread-4] INFO lab.test.concurrent.CyclicBarrierLab - 3
    //14:25:50.341 [main] INFO lab.test.concurrent.CyclicBarrierLab - cyclicBarrier.getNumberWaiting():1
    //14:25:50.344 [main] INFO lab.test.concurrent.CyclicBarrierLab - cyclicBarrier.getNumberWaiting():0
    //14:25:50.354 [pool-1-thread-2] ERROR lab.test.concurrent.CyclicBarrierLab - null
    //java.util.concurrent.BrokenBarrierException: null
    //	at java.util.concurrent.CyclicBarrier.dowait(CyclicBarrier.java:250)
    //	at java.util.concurrent.CyclicBarrier.await(CyclicBarrier.java:362)
    //	at lab.test.concurrent.CyclicBarrierLab$MyThread.run(CyclicBarrierLab.java:51)
    //	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
    //	at java.util.concurrent.FutureTask.run$$$capture(FutureTask.java:266)
    //	at java.util.concurrent.FutureTask.run(FutureTask.java)
    //	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
    //	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
    //	at java.lang.Thread.run(Thread.java:748)
    //14:25:50.354 [pool-1-thread-2] INFO lab.test.concurrent.CyclicBarrierLab - 4
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            executePool.submit(new MyThread(i));
            Thread.sleep(500);
        }
        log.info("cyclicBarrier.getNumberWaiting():{}", cyclicBarrier.getNumberWaiting());
        cyclicBarrier.reset();
        log.info("cyclicBarrier.getNumberWaiting():{}", cyclicBarrier.getNumberWaiting());
    }

    static class MyThread extends Thread {
        int i;

        public MyThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
            log.info("" + i);
        }
    }

}
