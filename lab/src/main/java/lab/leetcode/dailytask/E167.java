package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author jasonsong
 * 2020/7/20
 */


public class E167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 6, 7, 11, 15}, 10)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if (length < 2) {
            return new int[0];
        }
        for (int i = 0, j = length - 1; i < j; ) {
            int total = numbers[i] + numbers[j];
            if (total == target) {
                return new int[]{i + 1, j + 1};
            } else if (total > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }


}
