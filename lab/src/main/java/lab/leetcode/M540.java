package lab.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jasonsong
 * 2019/9/26
 * <p>
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */

@Slf4j
public class M540 {
    public static void main(String[] args) {
        int[][] numsArr = {{1, 1,5,5,7,7,9,9,6,6,22,22, 2, 3, 3, 4, 4, 8, 8}, {3, 3, 7, 7, 10, 11, 11}, {3, 3, 7, 7, 10, 10, 11},{3, 3, 7, 7,9,9, 10, 10, 11}, {0, 1, 1}, {1, 1, 2}, {323, 333, 333}};
        for (int[] nums : numsArr) {
            int result = singleNonDuplicate(nums);
            log.info("nums:{},result:{}", nums, result);
        }

    }




    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(m % 2 == 1) m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            if(nums[m] == nums[m + 1]) l = m + 2;
            else h = m;
        }
        return nums[l];
    }


    /**
     * 错误解答，待完善
     */
//    public static int singleNonDuplicate(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int l = 0, h, m, tempLength;
//        h = nums.length - 1;
//        while (l + 2 < h) {
//            m = l + (h - l) / 2;
//            tempLength = m - l;
//            if ((tempLength % 2 == 0 && nums[m] == nums[m + 1]) || (tempLength % 2 == 1 && nums[m] == nums[m - 1])) {
//                l = m;
//            } else {
//                h = m;
//            }
//        }
//        if (h - l == 1) {
//            if (nums[l + 1] == nums[l + 2]) {
//                return nums[l];
//            } else {
//                return nums[l + 1];
//            }
//        } else {
//            if (nums[l] == nums[l + 1]) {
//                return nums[l + 2];
//            } else {
//                return nums[l];
//            }
//        }
//
//    }
}










































