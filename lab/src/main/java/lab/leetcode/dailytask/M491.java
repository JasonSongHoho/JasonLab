package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author jasonsong
 * 2020/8/26
 */


public class M491 {
    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        M491 m491 = new M491();
        System.out.println(m491.findSubsequences(new int[]{6, 4, 7, 7}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        Arrays.sort(nums);
        double total = Math.pow(2D, length);
        for (int i = 0; i < total; i++) {
            Stack<Integer> stack = new Stack<>();
            int temp = i;
            for (int j = length; j > 0; j--) {
                double shift = Math.pow(2D, j);
                if (temp / shift == 1) {
                    stack.push(nums[j-1]);
                    temp -= shift;
                }
            }
            List<Integer> item = new LinkedList<>();
            while (!stack.isEmpty()) {
                item.add(stack.pop());
            }
            if (item.size() > 1 && !contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    private boolean contains(List<Integer> item) {
        StringBuilder key = new StringBuilder();
        for (Integer integer : item) {
            key.append(integer).append(",");
        }
        String keyStr = key.toString();
        if (set.contains(keyStr)) {
            return true;
        } else {
            set.add(keyStr);
            return false;
        }
    }
}
