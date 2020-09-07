package lab.leetcode.dailytask;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author jasonsong
 * 2020/9/7
 */


public class E283 {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = 0, j = 0;
        while (true) {
            while (nums[j] != 0) {
                j++;
                if (j >= nums.length) {
                    return;
                }
            }
            i = j;
            while (nums[i] == 0) {
                i++;
                if (i >= nums.length) {
                    return;
                }
            }
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
