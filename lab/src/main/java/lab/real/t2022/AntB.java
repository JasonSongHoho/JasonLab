package lab.real.t2022;

import com.google.common.collect.Lists;
import javafx.util.Pair;
import lombok.Data;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 笔试题B:
 * 在股票买卖场景中，有两个List， A 和 B。 A代表的是股权买入列表（买入份数、单价，时间），B代表的是股权卖出列表（卖出份数，单价，时间)
 * 计算：剩余的总份数以及剩余部分的买入总金额
 * 买入list :
 * 第一次： <1000, 1.5, 2021-01-01>
 * 第二次： <1000, 2.1, 2021-01-05>
 * 第三次： <1000, 1.7, 2021-01-07>
 * 第四次： <1000, 1.1, 2021-01-09>
 * 卖出list :
 * 第一次： <2500, 2.2, 2021-01-08>
 * 则结果为： <1500, 1950>
 * 要求：先买的会被先卖，先进先出原则; 每一次买或卖，所有份数的单价都是相同的
 *
 * @author Jason/XiaoJie
 * @date 2022/6/13
 */
public class AntB {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<Integer, Double> result = calcuBalence(
                Lists.newArrayList(new Transaction(1000, 1.5, new Date(currentTimeMillis)),
                        new Transaction(1000, 2.1, new Date(currentTimeMillis + 10)),
                        new Transaction(1000, 1.7, new Date(currentTimeMillis + 20)),
                        new Transaction(1000, 1.1, new Date(currentTimeMillis + 30))),
                Lists.newArrayList(new Transaction(2500, 2.2, new Date(currentTimeMillis + 25)),
                        new Transaction(1000, 2.2, new Date(currentTimeMillis + 35))));
        System.out.println("result:" + result);
    }

    public static Pair<Integer, Double> calcuBalence(List<Transaction> buyRecords, List<Transaction> sellRecords) {
        //遍历卖出记录
        for (Transaction sellRecord : sellRecords) {
            Date date = sellRecord.getDate();
            int nums = sellRecord.getNums();
            int tempNums = 0;
            Iterator<Transaction> iterator = buyRecords.iterator();
            //从买入记录中从前到后凑出卖出的份额数
            while (iterator.hasNext()) {
                Transaction buyRecord = iterator.next();
                if (buyRecord.getDate().after(date)) {
                    break;
                }
                if (tempNums + buyRecord.getNums() < nums) {
                    tempNums += buyRecord.getNums();
                    iterator.remove();
                } else {
                    buyRecord.setNums(nums - tempNums);
                    tempNums = nums;
                    break;
                }
            }
            //卖出记录有误，比剩余份数更多
            if (tempNums < nums) {
                throw new RuntimeException("sellRecords is wrong");
            }
        }
        int totalNums = 0;
        double totalPrice = 0;
        //遍历，累加剩余的买入记录
        for (Transaction buyRecord : buyRecords) {
            totalNums += buyRecord.getNums();
            totalPrice += (buyRecord.getNums() * buyRecord.getPrice());
        }
        return new Pair<>(totalNums, totalPrice);
    }

    @Data
    public static class Transaction {
        int nums;
        double price;
        Date date;

        public Transaction(int nums, double price, Date date) {
            this.nums = nums;
            this.price = price;
            this.date = date;
        }
    }

}
