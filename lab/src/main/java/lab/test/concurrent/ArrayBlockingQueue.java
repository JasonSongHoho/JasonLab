package lab.test.concurrent;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自己实现一个阻塞队列
 *
 * @author jasonsong
 * 2020/6/29
 */

@Slf4j
public class ArrayBlockingQueue<E> {
    private Lock lock = new ReentrantLock();
    private Condition notEmpty;
    private Condition notFull;
    private int capacity;
    private int size = 0;
    private List<E> list;

    public ArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor executor = ThreadUtil.newExecutor(1000, 1000);
            ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
            for (int i = 0; i < 20; i++) {
                executor.execute(new HandleThread(arrayBlockingQueue, true, i));
            }
            Thread.sleep(100);
            for (int i = 0; i < 30; i++) {
                executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            }
            Thread.sleep(100);
            for (int i = 0; i < 30; i++) {
                executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            }
            Thread.sleep(100);
            for (int i = 20; i < 80; i++) {
                executor.execute(new HandleThread(arrayBlockingQueue, true, i));
            }
            Thread.sleep(100);
            for (int i = 0; i < 40; i++) {
                executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            }
            System.out.println(arrayBlockingQueue.getAll().toString());
            Thread.sleep(100);
            System.out.println(arrayBlockingQueue.getAll().toString());
            Thread.sleep(100);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        int wakeUpTimes = 0;
        try {
            while (size == capacity) {
                log.info("can't put cause is full");
                notFull.await();
                if (++wakeUpTimes > 1) {
                    log.info("put thread wake up {} times", wakeUpTimes);
                }
            }
            list.add(e);
            log.info("put" + e.toString());
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public E take() throws InterruptedException {
        lock.lock();
        E e;
        int wakeUpTimes = 0;
        try {
            while (size == 0) {
                log.info("can't take cause is empty");
                notEmpty.await();
                if (++wakeUpTimes > 1) {
                    log.info("take thread wake up more than 1 times");
                }
            }
            e = list.remove(0);
            log.info("take" + e.toString());
            size--;
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public List<E> getAll() {
        lock.lock();
        try {
            return new ArrayList<>(list);
        } finally {
            lock.unlock();
        }
    }

    static class HandleThread implements Runnable {
        ArrayBlockingQueue<Integer> arrayBlockingQueue;
        boolean isPut;
        Integer num;


        public HandleThread(ArrayBlockingQueue<Integer> arrayBlockingQueue, boolean isPut, Integer num) {
            this.arrayBlockingQueue = arrayBlockingQueue;
            this.isPut = isPut;
            this.num = num;
        }

        @Override
        public void run() {
            try {
                if (isPut) {
                    arrayBlockingQueue.put(num);
                } else {
                    arrayBlockingQueue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
