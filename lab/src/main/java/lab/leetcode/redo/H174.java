package lab.leetcode.redo;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	    3
 * -5	   -10	    1
 * 10	    30	   -5 (P)
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 通过次数16,959提交次数37,278
 * <p>
 * <p>
 * <p>
 * [[1,-3,3],[0,-2,0],[-3,-3,-3]]
 *
 * @author jasonsong
 * 2020/7/12
 */


public class H174 {
    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/dungeon-game/solution/di-xia-cheng-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }


    public static int calculateMinimumHP1(int[][] dungeon) {
        int n = dungeon.length;
        if (n == 0) {
            return 0;
        }
        int m = dungeon[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        int[][] min = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            min[0][i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= n; i++) {
            min[i][0] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == n && j == m) {
                    min[i][j] = dp[i][j] = dungeon[i - 1][j - 1];
                    continue;
                }
                if (min[i][j - 1] > min[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1] + dungeon[i - 1][j - 1];
                    min[i][j] = Math.min(min[i][j - 1], dp[i][j]);
                } else if (min[i][j - 1] < min[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j] + dungeon[i - 1][j - 1];
                    min[i][j] = Math.min(min[i - 1][j], dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + dungeon[i - 1][j - 1];
                    min[i][j] = Math.min(min[i - 1][j], dp[i][j]);
                }
            }
        }
        if (min[n][m] > 0) {
            return 1;
        } else {
            return -min[n][m] + 1;
        }
    }

}
