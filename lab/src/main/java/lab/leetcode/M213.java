package lab.leetcode;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 通过次数247,156提交次数565,341
 *
 * @author Jason/XiaoJie
 * @date 2022/5/26
 */
public class M213 {
    class Solution {
        int n = 0;

        public int rob(int[] nums) {
            n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            if (n == 3) {
                return Math.max(Math.max(nums[0], nums[2]), nums[1]);
            }
            return Math.max(getMax(nums, 0, n - 1), getMax(nums, 1, n));
        }

        public int getMax(int[] nums, int start, int end) {
            int[] dp = new int[n - 1];
            dp[0] = nums[start];
            dp[1] = Math.max(nums[start], nums[start + 1]);
            for (int i = 2; start + i < end; i++) {
                dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
            }
            return dp[n - 2];
        }
    }
}
