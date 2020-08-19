package lab.test.concurrent;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;

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
            ThreadPoolExecutor executor = ThreadUtil.newExecutor(20, 40);
            ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
            executor.execute(new HandleThread(arrayBlockingQueue, true, 1));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 2));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 3));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 4));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 5));
            Thread.sleep(100);

            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            Thread.sleep(100);
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            Thread.sleep(100);
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            executor.execute(new HandleThread(arrayBlockingQueue, false, null));
            Thread.sleep(100);
            executor.execute(new HandleThread(arrayBlockingQueue, true, 6));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 7));
            executor.execute(new HandleThread(arrayBlockingQueue, true, 8));
            Thread.sleep(100);
            System.out.println(arrayBlockingQueue.getAll().toString());
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            if (size == capacity) {
                notFull.await();
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
        try {
            if (size == 0) {
                notEmpty.await();
            }
            e = list.remove(0);
            log.info("take" + e.toString());
            size--;
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return e;
    }

    public List<E> getAll() {
        return list;
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
