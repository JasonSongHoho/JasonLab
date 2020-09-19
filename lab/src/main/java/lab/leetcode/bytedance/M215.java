package lab.leetcode.bytedance;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jasonsong
 * 2020/9/19
 */


public class M215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest2(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest2(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public static int findKthLargest1(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> priority = new PriorityQueue<>(length, (a, b) -> b - a);
        for (int i = 0; i < length; i++) {
            priority.offer(nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = priority.poll();
        }
        return ans;
    }

    public static int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> priority = new PriorityQueue<>(k + 1);
        for (int i = 0; i < k; i++) {
            priority.offer(nums[i]);
        }

        for (int i = k; i < length; i++) {
            priority.add(nums[i]);
            priority.poll();
        }
        return priority.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
