package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 *
 * @author Jason/XiaoJie
 * @date 2022/6/1
 */
public class M473 {
    int target = 0;
    int[] matchsticks;

    public static void main(String[] args) {
        new M473().makesquare(new int[]{1, 1, 2, 2, 2});
    }

    public boolean makesquare(int[] matchsticks) {
        int total = Arrays.stream(matchsticks).sum();
        if (total % 4 != 0) {
            return false;
        }
        target = total / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[matchsticks.length - 1] > target) {
            return false;
        }
        int temp;
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        this.matchsticks = matchsticks;
        int[] edges = new int[4];
        return dfs(edges, 0);
    }

    public boolean dfs(int[] edges, int index) {
        if (index == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= target && dfs(edges, index + 1)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }


    class Solution {
        /**
         * 作者：LeetCode-Solution
         * 链接：https://leetcode.cn/problems/matchsticks-to-square/solution/huo-chai-pin-zheng-fang-xing-by-leetcode-szdp/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param matchsticks
         * @return
         */
        public boolean makesquare(int[] matchsticks) {
            int totalLen = Arrays.stream(matchsticks).sum();
            if (totalLen % 4 != 0) {
                return false;
            }
            int len = totalLen / 4, n = matchsticks.length;
            int[] dp = new int[1 << n];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int s = 1; s < (1 << n); s++) {
                for (int k = 0; k < n; k++) {
                    if ((s & (1 << k)) == 0) {
                        continue;
                    }
                    int s1 = s & ~(1 << k);
                    if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                        dp[s] = (dp[s1] + matchsticks[k]) % len;
                        break;
                    }
                }
            }
            return dp[(1 << n) - 1] == 0;
        }
    }
}
