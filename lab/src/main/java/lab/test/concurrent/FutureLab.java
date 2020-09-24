package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

/**
 * @author jasonsong
 * 2020/9/22
 */

@Slf4j
public class FutureLab {
    public static void main(String[] args) {
        log.info("start");
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return doQuery(1);
            }
        });
        try {
            log.info("try get");
            Integer integer = completableFuture1.get(10, TimeUnit.SECONDS);
            log.info("finish :{}", integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
//
//        CompletableFuture<Integer> completableFuture = queryAsync();
//        try {
//            log.info("try get");
//            Integer integer = completableFuture.get();
//            log.info("finish :{}", integer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    static CompletableFuture<Integer> queryAsync() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                int doQuery = doQuery(1);
                completableFuture.complete(doQuery);
            } catch (Exception e) {
                e.printStackTrace();
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;
    }

    static int doQuery(int i) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
