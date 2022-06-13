package lab.real.t2022;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 笔试题A:
 * 1。 有二十个账户。每个账户初始余额10000元。
 * 2。 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
 * 3。 每个线程执行100次转账操作。
 * 4。 最后请打印出二十个账户的余额
 * <p>
 * <p>
 *
 * @author Jason/XiaoJie
 * @date 2022/6/13
 */
public class AntA {
    Map<Integer, AtomicInteger> map;
    int total;

    public AntA(int total, int init) {
        this.total = total;
        map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            map.put(i, new AtomicInteger(init));
        }
    }

    public static void main(String[] args) {
        AntA antA = new AntA(20, 10000);

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("jasonLab-%d").build();
        ExecutorService service = new ThreadPoolExecutor(10, 10,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5000), threadFactory);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    antA.transfer(random.nextInt(20), random.nextInt(20), random.nextInt(1000));
                }
            });
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(antA.printBalance()));
    }

    public void transfer(int fromUser, int toUser, int count) {
        if (count <= 0 || fromUser < 0 || fromUser >= total || toUser < 0 || toUser >= total) {
            return;
        }
        AtomicInteger balance = map.get(fromUser);
        int balanceNum;
        //转出方余额不足不会转账
        while (balance != null && (balanceNum = balance.get()) >= count) {
            boolean setSuccess = balance.compareAndSet(balanceNum, balanceNum - count);
            if (setSuccess) {
                AtomicInteger toBalance = map.get(toUser);
                toBalance.addAndGet(count);
                return;
            }
        }
    }

    public Map<Integer, Integer> printBalance() {
        Map<Integer, Integer> ans = new HashMap<>();
        long total = 0;
        for (Map.Entry<Integer, AtomicInteger> entry : map.entrySet()) {
            ans.put(entry.getKey(), entry.getValue().get());
            total += entry.getValue().get();
        }
        System.out.println("total:" + total);
        return ans;
    }


}
