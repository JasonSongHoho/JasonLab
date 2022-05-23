package lab.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 679. 24 点游戏
 * 给定一个长度为4的整数数组 cards 。你有 4 张卡片，每张卡片上都包含一个范围在 [1,9] 的数字。您应该使用运算符 ['+', '-', '*', '/'] 和括号 '(' 和 ')' 将这些卡片上的数字排列成数学表达式，以获得值24。
 * <p>
 * 你须遵守以下规则:
 * <p>
 * 除法运算符 '/' 表示实数除法，而不是整数除法。
 * 例如， 4 /(1 - 2 / 3)= 4 /(1 / 3)= 12 。
 * 每个运算都在两个数字之间。特别是，不能使用 “-” 作为一元运算符。
 * 例如，如果 cards =[1,1,1,1] ，则表达式 “-1 -1 -1 -1” 是 不允许 的。
 * 你不能把数字串在一起
 * 例如，如果 cards =[1,2,1,2] ，则表达式 “12 + 12” 无效。
 * 如果可以得到这样的表达式，其计算结果为 24 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: cards = [4, 1, 8, 7]
 * 输出: true
 * 解释: (8-4) * (7-1) = 24
 * 示例 2:
 * <p>
 * 输入: cards = [1, 2, 1, 2]
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * cards.length == 4
 * 1 <= cards[i] <= 9
 *
 * @author Jason/XiaoJie
 * @date 2022/5/24
 */
public class H679 {
    private static final double TARGET = 24d;
    private static final double ALLOW_DIFF_TO_ZERO = 1e-6;
    private static final int ADD = 0, MUL = 1, SUB = 2, DIV = 3;

    public static boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    public static boolean solve(List<Double> list) {
        int size = list.size();
        if (size == 1) {
            return Math.abs(TARGET - list.get(0)) <= ALLOW_DIFF_TO_ZERO;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                List<Double> mergedList = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        mergedList.add(list.get(k));
                    }
                }
                Double first = list.get(i);
                Double second = list.get(j);
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == ADD) {
                        mergedList.add(first + second);
                    } else if (k == MUL) {
                        mergedList.add(first * second);
                    } else if (k == SUB) {
                        mergedList.add(first - second);
                    } else {
                        if (Math.abs(second) > ALLOW_DIFF_TO_ZERO) {
                            mergedList.add(first / second);
                        } else {
                            continue;
                        }
                    }
                    if (solve(mergedList)) {
                        return true;
                    }
                    mergedList.remove(mergedList.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new MyThread(new int[]{4, 1, 8, 7}));
        executorService.execute(new MyThread(new int[]{1, 2, 1, 2}));
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {
        int[] nums;

        public MyThread(int[] nums) {
            super(null, null, "t", 1);
            this.nums = nums;
        }

        @Override
        public void run() {
            System.out.println(judgePoint24(nums));
        }
    }

}
