package lab.test.jave;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/18
 */
@Slf4j
public class TestCatchThreadPoolException {
    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(availableProcessors + 1, availableProcessors * 2,
                2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setUncaughtExceptionHandler((t, e) -> log.error("uncaughtException t:{}", thread.getName(), e));
                return thread;
            }
        }) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                log.error("afterExecute", t);
            }
        };

        executorService.execute(new MyTestThread("execute"));
        Future<Integer> future = executorService.submit(new MyTestCallable("submit"));

        try {
            future.get();
            TimeUnit.SECONDS.sleep(60);
            log.info("finish");
        } catch (Exception e) {
            log.error("", e);
        }
    }

    public static class MyTestThread implements Runnable {
        private String name;

        public MyTestThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            log.info("run MyTestThread:{}", name);
            throw new RuntimeException(name + " meet exception");
        }
    }

    public static class MyTestCallable implements Callable<Integer> {
        private String name;

        public MyTestCallable(String name) {
            this.name = name;
        }

        @Override
        public Integer call() {
            log.info("run MyTestCallable:{}", name);
            throw new RuntimeException(name + " meet exception");
        }
    }
}
