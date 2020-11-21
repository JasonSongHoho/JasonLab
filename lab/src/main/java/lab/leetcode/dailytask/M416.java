package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * @author jasonsong
 * 2020/10/16
 */


public class M416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 4}));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            boolean[] tmp = Arrays.copyOf(dp, target + 1);
            for (int j = num + 1; j <= target; j++) {
                dp[j] = tmp[j] || tmp[j - num];
                if (dp[target]) {
                    return true;
                }
            }
            dp[num] = true;
        }
        return dp[target];
    }
}
