package lab.leetcode.dailytask;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * abcdefghijk
 * 012345678910
 * <p>
 * l  m  n  o  p  q  r  s  t  u
 * 11 12 13 14 15 16 17 18 19 20
 * <p>
 * v  w  x  y  z
 * 21 22 23 24 25
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 122123343123121321417
 *
 * @author jasonsong
 * 2020/6/9
 */


@Slf4j
public class JZOF_M_46 {
    static int sum = 0;

    public static void main(String[] args) {
//        sum = 0;
//        System.out.println(translateNum2(12258));
//        System.out.println(sum);
//        System.out.println();
//        sum = 0;
//        System.out.println(translateNum2(1225));
//        System.out.println(sum);
//        System.out.println();


        System.out.println(translateNum2(12));
        System.out.println(translateNum2(1222));
        System.out.println(translateNum2(1225));

    }

    public static int translateNum2(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 10 || num % 100 > 25) {
            return translateNum2(num / 10);
        } else {
            return translateNum2(num / 10) + translateNum2(num / 100);
        }
    }

    public static int translateNum(int num) {
        String numStr = "" + num;
        int numLength = numStr.length();
        int[] dp = new int[numLength + 1];
        dp[0] = 1;

        for (int i = 0; i < numLength; i++) {
            dp[i + 1] += dp[i];
            if (i > 0) {
                if (numStr.charAt(i - 1) != '0' && numStr.substring(i - 1, i + 1).compareTo("25") <= 0) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }
        return dp[numLength];
    }

    public int translateNum1(int num) {
        // 递归，两位两位地看
        if (num < 10) return 1;
        // 如果末两位形如01，或者33，这种只能读一位
        if (num % 100 < 10 || num % 100 > 25)
            return translateNum(num / 10);
        // 如果末两位形如 12， 可以有两种读法，读2， 或者读12
        return translateNum(num / 10) + translateNum(num / 100);
    }

}
