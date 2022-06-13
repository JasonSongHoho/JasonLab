package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/13
 */
public class E1051 {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int ans = 0;
        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                ans++;
            }
        }
        return ans;
    }
}
