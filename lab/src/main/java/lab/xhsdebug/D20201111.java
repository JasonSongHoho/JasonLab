package lab.xhsdebug;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jason / XiaoJie
 * @date 2020/11/11
 */
public class D20201111 {

    public static void main(String[] args) {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        ExecutorService ts = Executors.newFixedThreadPool(100);

        for (; ; ) {
            ts.execute(new Runnable() {
                @Override
                public void run() {
//                    long lValue = Math.abs(dv);
                    long lValue = (long) (Math.random() * 33162002656000L);
                    try {
                        //生成随机数，格式化日期
                        String format = df.format(new Date(lValue));
                        System.out.println(format);
                    } catch (Exception e) {
                        System.out.println("lValue:" + lValue);
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            });
        }
    }
}
