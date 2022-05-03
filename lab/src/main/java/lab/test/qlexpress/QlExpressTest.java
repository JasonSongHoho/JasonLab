package lab.test.qlexpress;

import cn.hutool.core.util.RandomUtil;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jason/XiaoJie
 * @date 2021/6/1
 */
@Slf4j
public class QlExpressTest {
    static ExpressRunner runner = new ExpressRunner();
    static String express = "if (weekDay == 5 && hour >= 20 && hour < 24) then {return NewList(\"今晚宜分享开启周末的喜悦\",\"来和大家聊聊周末去哪玩吧～\",\"聊聊本周发生的趣事呀~\");} " +
            "else if (hour >= 7 && hour < 9) then {return NewList(\"新的一天开始啦！来说个早安吧\",\"有趣的梦要跟大家分享哦～\",\"新的一天，发句语音鼓励一下大家吧～\")} " +
            "else if (hour >= 20 && hour < 23) then {return NewList(\"天黑啦，和大家道个晚安吧\",\"聊聊今天发生的趣事呀~\",\"不开心的事情别憋着，说出来吧\",\"今夜宜给大家唱首小歌哦~\")} " +
            "else if ((hour >= 0 && hour < 3) || ((hour >= 23 && hour < 24))) then {return NewList(\"夜深了，和大家说点悄悄话吧\",\"深夜的情绪要说出来哦～\",\"睡不着，就来和大家唠会儿磕吧～\")} " +
            "else {return NewList(\"分享你的开心，开心可以加倍哦！\",\"难过的时候，不要憋在心里~\",\"爱唱歌的人运气都不会太差呢~\",\"分享一个最近听到的笑话吧～\");} ";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            m1();
        }
        log.info("total cost {} ms ", System.currentTimeMillis() - start);
    }

    public static void m1() {
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("day", 6);
        context.put("weekDay", RandomUtil.randomInt(1, 8));
        context.put("hour", RandomUtil.randomInt(0, 24));
        context.put("minute", 3);
        context.put("second", 3);
        Object result = null;
//        long start = System.currentTimeMillis();
        try {
            result = runner.execute(express, context, null, true, false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
//        log.info("cost {} ms, result is {}", System.currentTimeMillis() - start, JSON.toJSONString(result));
//        log.info("cost {} ms, result is {}", System.currentTimeMillis() - start, JSON.toJSONString(result));
    }
}
