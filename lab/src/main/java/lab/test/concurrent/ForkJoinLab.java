package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author jasonsong
 * 2020/9/26
 */

@Slf4j
public class ForkJoinLab {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1, 16);
        log.info("submit sumTask");
        ForkJoinTask<Integer> future = forkJoinPool.submit(sumTask);

        try {
            log.info("future.get...");
            Integer integer = future.get();
            log.info("future.get result :{}", integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class SumTask extends RecursiveTask<Integer> {
        private int start;
        private int end;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;

        }

        @Override
        protected Integer compute() {
            int total = end - start + 1;
            if (total <= 2) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return start + end;
            } else {
                int m = start + (end - start) / 2;
                SumTask leftTask = new SumTask(start, m);
                SumTask rightTask = new SumTask(m + 1, end);
                //执行子任务
                log.info("leftTask.fork() start:{}, end:{}", start, m);
                leftTask.fork();
                log.info("rightTask.fork() start:{}, end:{}", m + 1, end);
                rightTask.fork();
                //得到子任务的执行结果
                log.info("start leftTask.join() start:{}, end:{}", start, m);
                int resultLeft = leftTask.join();
                log.info("finish leftTask.join() start:{}, end:{}", start, m);

                log.info("start rightTask.join() start:{}, end:{}", m + 1, end);
                int resultRight = rightTask.join();
                log.info("finish rightTask.join() start:{}, end:{}", m + 1, end);

                return resultLeft + resultRight;
            }
        }
    }
}
