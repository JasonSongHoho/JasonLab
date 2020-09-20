package lab.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/20
 */


public class M120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int m = 0;
        for (List<Integer> ignored : triangle) {
            m++;
        }
        if (m == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[m + 1];
        int[] temp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(temp, Integer.MAX_VALUE);
        dp[1] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                Integer item = list.get(j);
                temp[j + 1] = Math.min(dp[j], dp[j + 1]) + item;
            }
            dp = Arrays.copyOf(temp, m + 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
