package lab.test;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jasonsong
 * 2020/7/27
 */


public class ThreadLocalLab {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static ThreadFactory threadFactory = ThreadFactoryBuilder.create().setNamePrefix("ThreadLocalLab-thread-").build();
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 16,
            2, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), threadFactory);

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
//                System.out.println("thread name:"+ threadName);
                threadLocal.set(threadName);
            });
        }
        for (int i = 0; i < 8; i++) {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("thread name:" + threadName);
                String s = threadLocal.get();
                System.out.println("threadLocal value:" + s);
            });
        }
    }


}
