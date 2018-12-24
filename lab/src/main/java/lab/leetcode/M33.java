package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jasonsong
 * 2018/12/23
 */


public class M33 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M33.class);

    public static void main(String[] args) {
        M33 m33 = new M33();
        int[] nums = {4, 5, 7, 11, 15, 1, 2, 3};
        //
        int[] targets = {4, 12, 15, 18, 0, 1, 3};
        for (int i : targets) {
            LOGGER.info("target:{},result:{}", i, m33.search(nums, i));
        }
    }

    public int search(int[] nums, int target) {
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

}
