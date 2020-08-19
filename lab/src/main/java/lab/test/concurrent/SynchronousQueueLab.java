package lab.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue里不能存储元素， 每个put()都必须等到一个take()，才能解除阻塞, 反之亦然。
 *
 * @author jasonsong
 * 2020/8/17
 */


public class SynchronousQueueLab {

    public static void main(String[] args) throws InterruptedException {
        int size = 8;
        ExecutorService executorService = Executors.newFixedThreadPool(size * 2);
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        for (int i = 0; i < size; i++) {
            executorService.submit(new MyThread("value" + i, synchronousQueue));
            Thread.sleep(200);
        }
        for (int i = 0; i < size; i++) {
            Thread.sleep(200);
            System.out.println("try to take one value ");
            String value1 = synchronousQueue.take();
            System.out.println("have take value " + value1);
        }

        System.out.println("---------------------------------------------");

        for (int i = 0; i < size; i++) {
            executorService.submit(() -> {
                System.out.println("trying to take one value ");
                String value1 = null;
                try {
                    value1 = synchronousQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("have take value " + value1);
            });
            Thread.sleep(200);
        }
        for (int i = 0; i < size; i++) {
            executorService.submit(new MyThread("value" + i, synchronousQueue));
            Thread.sleep(200);
        }
    }

    static class MyThread extends Thread {
        String valueName;
        SynchronousQueue<String> synchronousQueue;

        public MyThread(String valueName, SynchronousQueue<String> synchronousQueue) {
            this.valueName = valueName;
            this.synchronousQueue = synchronousQueue;
        }

        @Override
        public void run() {
            try {
                System.out.println("trying to put value " + valueName + ". synchronousQueue.size():" + synchronousQueue.size());
                synchronousQueue.put(valueName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


