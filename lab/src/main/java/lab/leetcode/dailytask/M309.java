package lab.leetcode.dailytask;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @author jasonsong
 * 2020/7/10
 */


public class M309 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

    /**
     * DP 优化了 空间复杂度
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        int tmp0;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 1; i <= length; i++) {
            tmp0 = Math.max(dp0, dp2 - prices[i - 1]);
            tmp1 = dp0 + prices[i - 1];
            tmp2 = Math.max(dp1, dp2);
            dp0 = tmp0;
            dp1 = tmp1;
            dp2 = tmp2;
        }
        return Math.max(tmp1, tmp2);
    }

    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int[][] dp = new int[length + 1][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i <= length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i-1]);
            dp[i][1] = dp[i - 1][0]+ prices[i-1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[length][1], dp[length][2]);
    }
}
