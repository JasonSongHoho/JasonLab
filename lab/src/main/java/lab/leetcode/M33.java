package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * @author jasonsong
 * 2018/12/23
 */


public class M33 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M33.class);

    public static void main(String[] args) {
        int[] nums = {4, 5, 7, 11, 15, 1, 2, 3};
        int[] nums1 = {4, 5, 7, 11, 1, 2, 3};
        int[] nums2 = {4, 5, 7, 11, 1};
        int[] nums3 = {7, 11, 1};
        //
        int[] targets = {4, 12, 15, 18, 0, 1, 3};

        for (int i : targets) {
            LOGGER.info("target:{},result:{}", i, M33.search(nums, i));
            LOGGER.info("target:{},result:{}", i, M33.search(nums1, i));
            LOGGER.info("target:{},result:{}", i, M33.search(nums2, i));
        }
    }

    public static int search0(int[] nums, int target) {
        if (nums == null || nums.length < 1) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //条件1
            if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //条件2
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

//    public int search(int[] nums, int target) {
//        int length = nums.length;
//        if (target < nums[0] && target > nums[length - 1]) {
//            return -1;
//        }
//        int mid;
//        int l = 0;
//        int h = length - 1;
//        while (l < h - 1) {
//            mid = l + (h - l) / 2;
//            if (target == nums[mid]) {
//                return mid;
//            } else if (target >= nums[l] && target < nums[mid]) {
//                if (target <= nums[h]) {
//                    l = mid;
//                    continue;
//                }
//
//                if (nums[mid] > nums[l]) {
//                    h = mid;
//                } else {
//                    for (int i = mid; i > l; i--) {
//                        if (nums[i] == target) {
//                            return i;
//                        } else if (nums[i] > nums[i + 1] || nums[i] < target) {
//                            return -1;
//                        }
//                    }
//                }
//            } else {
//                if (target >= nums[h]) {
//                    h = mid;
//                    continue;
//                }
//                if (nums[mid] < nums[h]) {
//                    l = mid;
//                } else {
//                    for (int i = mid; i < h; i++) {
//                        if (nums[i] == target) {
//                            return i;
//                        } else if (nums[i] < nums[i - 1] || nums[i] > target) {
//                            return -1;
//                        }
//                    }
//                }
//            }
//        }
//        if (target == nums[l]) {
//            return l;
//        } else if (target == nums[h]) {
//            return h;
//        }
//        return -1;
//    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1){
            return target == nums[0] ? 0 : -1;
        }
        int l = 0, r = len -1, m;
        while(l <= r){
            m = ((l+r) >> 1);
            if(target == nums[m]){
                return m;
            }
            if(nums[0] <= nums[m]){
                if(nums[0] <= target && target < nums[m]){
                    r = m - 1;
                } else{
                    l = m + 1;
                }
            } else {
                if(nums[m] < target && target <= nums[len-1]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }


}
