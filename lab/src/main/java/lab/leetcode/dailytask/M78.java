package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/20
 */


public class M78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return result;
        }
        double total = 1 << length;
        for (int i = 0; i < total; i++) {
            List<Integer> item = new ArrayList<>();
            int j = 0;
            int k = i;
            while (k > 0) {
                if (k % 2 == 1) {
                    item.add(nums[j]);
                }
                j++;
                k = k / 2;
            }
            result.add(item);
        }
        return result;
    }
}
