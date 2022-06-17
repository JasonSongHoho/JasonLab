package lab.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/16
 */
public class M494 {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static int[] tempNums = new int[0];
    static int[] nums = new int[0];

    public static int findTargetSumWays(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            map.put(i, new HashSet<>());
        }
        tempNums = nums;
        return dfs(nums.length - 1, target);
    }

    private static int dfs(int end, int target) {
        int ans = 0;
        if (end == 0) {
            if (tempNums[0] == target || -tempNums[0] == target) {
                Set<Integer> set = map.get(0);
                set.add(target);
                return target == 0 ? 2 : 1;
            }
        } else {
            Set<Integer> set = map.get(end - 1);
            int newTarget = target - tempNums[end];
            if (set.contains(newTarget)) {
                ans = newTarget == 0 ? ans + 2 : ans + 1;
            } else {
                ans += dfs(end - 1, newTarget);
            }
            newTarget = target + tempNums[end];
            if (set.contains(newTarget)) {
                ans = newTarget == 0 ? ans + 2 : ans + 1;
            } else {
                ans += dfs(end - 1, newTarget);
            }
        }
        return ans;
    }
}
