package lab.xhsdebug;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import static cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN;

/**
 * @author Jason/XiaoJie
 * @date 2021/2/8
 */
@Slf4j
public class TimeUtil {
    public static void main(String[] args) {
        long date = 1619841600000L;
        for (int i = 1; i <= 31; i++) {
            String format = DateUtil.format(new Date(date), NORM_DATETIME_PATTERN);
            String msg = StrUtil.format("timeStamp: {} date: {} ", date, format);
            System.out.println(msg);
            date += 86400 * 1000;
        }
    }
}
