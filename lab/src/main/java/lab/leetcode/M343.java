package lab.leetcode;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @author jasonsong
 * 2020/6/11
 */


public class M343 {
    public static void main(String[] args) {

        System.out.println("2:" + integerBreak(2));
        System.out.println("3:" + integerBreak(3));
        System.out.println("4:" + integerBreak(4));
        System.out.println("5:" + integerBreak(5));
        System.out.println("6:" + integerBreak(6));
        System.out.println("7:" + integerBreak(7));
        System.out.println("8:" + integerBreak(8));
        System.out.println("9:" + integerBreak(9));
        System.out.println("10:" + integerBreak(10));
        System.out.println("11:" + integerBreak(11));
        System.out.println("20:" + integerBreak(20));
        System.out.println("58:" + integerBreak(58));
    }

    /**
     * 数学方法
     *
     * @param n
     * @return
     */
    public static int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int total = 1;
            while (true) {
                if (n < 5) {
                    return total * n;
                } else {
                    total *= 3;
                    n -= 3;
                }
            }
        }
    }

    /**
     * 数学方法
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else {
            int num = n / 3;
            int left = n % 3;

            if (left == 1) {
                num--;
                left = 4;
            } else if (left == 0) {
                left = 1;
            }
            return (int) Math.pow(3, num) * left;
        }
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

}
