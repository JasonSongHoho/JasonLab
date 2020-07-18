package lab.leetcode.dailytask;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 *
 * @author jasonsong
 * 2020/7/17
 * todo redo
 */


public class E35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    /**
     * 执行结果： 通过
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：39.1 MB , 在所有 Java 提交中击败了 9.26% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int point = low + (high - low) / 2;
        while (low <= high) {
            int value = nums[point];
            if (value == target) {
                return point;
            } else if (value < target) {
                low = point + 1;
            } else {
                high = point - 1;
            }
            point = low + (high - low) / 2;
        }
        return point;
    }

}
