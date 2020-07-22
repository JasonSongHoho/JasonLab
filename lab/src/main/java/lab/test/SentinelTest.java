package lab.test;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.context.ContextUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jasonsong
 * 2020/5/18
 */

@Slf4j
public class SentinelTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            FlowControl.initFlowRules("test", 1, "" + i);
        }
        for (int i = 0; i < 100; i++) {
            ContextUtil.enter("n1", "" + i);
            Entry entry = null;
            try {
                entry = SphU.entry("test");
                /*您的业务逻辑 - 开始*/
                log.info("hello world " + i);
                /*您的业务逻辑 - 结束*/
            } catch (BlockException e1) {
                /*流控逻辑处理 - 开始*/
                log.info("block! " + i);
                /*流控逻辑处理 - 结束*/
            } finally {
                if (entry != null) {
                    entry.exit();
                }
                ContextUtil.exit();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 9) {
                i = 0;
            }
        }
    }

//    public static void main(String[] args) {
//        RateLimiter rateLimiter= RateLimiter.create(0.01D);
////        rateLimiter.tryAcquire(Duration.ofSeconds(1));
//
//        for (int i = 0; i < 10; i++) {
//            double cost = rateLimiter.acquire();
//            System.out.println("获取1个令牌结束，时间为" + new Date() + ", 耗时" + cost + "ms");
//
//        }
//
//    }

}
