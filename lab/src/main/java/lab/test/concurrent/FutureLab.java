package lab.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author jasonsong
 * 2020/9/22
 */

@Slf4j
public class FutureLab {
    public static void main(String[] args) {
        log.info("start");
        CompletableFuture<Integer> completableFuture = queryAsync();
        try {
            log.info("try get");
            Integer integer = completableFuture.get();
            log.info("finish :{}", integer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static CompletableFuture<Integer> queryAsync() {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            completableFuture.complete(doQuery(1));
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
