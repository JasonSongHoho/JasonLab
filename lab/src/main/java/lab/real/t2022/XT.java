package lab.real.t2022;

import cn.hutool.core.util.RandomUtil;
import lombok.SneakyThrows;

import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 用栈实现队列
 * <p>
 * 进出队列 O(1)
 * 线程安全
 * 锁粒度要小
 *
 * @author Jason/XiaoJie
 * @date 2022/6/17
 */
public class XT<E> {
    private Stack<E> fromStack;
    private Stack<E> toStack;
    private ReentrantReadWriteLock rwLock;
    private ReentrantReadWriteLock.ReadLock readLock;
    private ReentrantReadWriteLock.WriteLock writeLock;

    public XT() {
        fromStack = new Stack<>();
        toStack = new Stack<>();
        rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
    }

    @SneakyThrows
    public static void main(String[] args) {
        XT<Integer> xt = new XT<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 10; i++) {
            int num = RandomUtil.randomInt(10);
            xt.push(num);
            System.out.print(" push: " + num);
        }
        Thread.sleep(100);
        System.out.println("____________________________");
        for (int i = 0; i < 10; i++) {
            Integer take = xt.take();
            System.out.print(" take: " + take);
//            int finalI = i;
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    Integer take = xt.take();
//                    System.out.print(" take i: " + finalI + ", val: " + take);
//                }
//            });
        }
    }

    private void push(E val) {
        readLock.lock();
        try {
            fromStack.push(val);
        } finally {
            readLock.unlock();
        }
    }

    private E take() {
        writeLock.lock();
        try {
            transfer(fromStack, toStack);
            if (!toStack.isEmpty()) {
                E pop = toStack.pop();
                transfer(toStack, fromStack);
                return pop;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            writeLock.unlock();
        }
    }

    private void transfer(Stack<E> fromStack, Stack<E> toStack) {
        while (!fromStack.isEmpty()) {
            toStack.push(fromStack.pop());
        }
    }

}
