package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author jasonsong
 * 2020/6/24
 */


public class M16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        int closestAbs = Math.abs(target - closestSum);
        int currentTotal;
        int currentAbs;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                currentTotal = nums[i] + nums[j] + nums[k];
                if (currentTotal == target) {
                    return currentTotal;
                } else if (currentTotal < target) {
                    j++;
                } else {
                    k--;
                }
                currentAbs = Math.abs(target - currentTotal);
                if (closestAbs > currentAbs) {
                    closestSum = currentTotal;
                    closestAbs = currentAbs;
                }
            }
        }
        return closestSum;
    }

}
