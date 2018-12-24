package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author jasonsong
 * 2018/12/23
 */


public class M215 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M215.class);

    public static void main(String[] args) {
        M215 m215 = new M215();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        LOGGER.info("result:{}", m215.findKthLargest(nums, k));

    }

    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        list.sort((o1, o2) -> o2 - o1);
        for (int i = k; i < nums.length; i++) {
            int val = nums[i];
            for (int j = 0; j < k; j++) {
                if (val > list.get(j)) {
                    list.add(j, val);
                    break;
                }
            }
        }
        return list.get(k - 1);
    }

    /**
     * 堆排序法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
