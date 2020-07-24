package lab.leetcode.dailytask;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @author jasonsong
 * 2020/7/23
 */


public class M64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        int lengthM = grid.length;
        if (lengthM == 0) {
            return 0;
        }
        int lengthN = grid[0].length;
        if (lengthN == 0) {
            return 0;
        }
        int[][] dp = new int[lengthM + 1][lengthN + 1];
        for (int i = 0; i <= lengthM; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= lengthN; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= lengthM; i++) {
            for (int j = 1; j <= lengthN; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = grid[0][0];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[lengthM][lengthN];
    }
}
