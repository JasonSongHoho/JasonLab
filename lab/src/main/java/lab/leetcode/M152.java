package lab.leetcode;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 *
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class M152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int negative = nums[0] <= 0 ? nums[0] : 1;
        int max = nums[0];
        int ans = max, temp;
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                negative = 0;
                max = 0;
            } else if (nums[i] > 0) {
                max = max > 0 ? max * nums[i] : nums[i];
                negative = negative < 0 ? negative * nums[i] : nums[i];
            } else {
                temp = negative;
                negative = max > 0 ? max * nums[i] : nums[i];
                max = temp < 0 ? temp * nums[i] : nums[i];
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
