package lab.leetcode;

import java.util.Random;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class M169 {

    /**
     * Boyer-Moore 算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int majorityElement0(int[] nums) {
        int candidate = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }
            cnt += nums[i] == candidate ? 1 : -1;
        }
        return candidate;
    }

    /**
     * 随机化
     * 思路
     * <p>
     * 因为超过 n/2 的数组下标被众数占据了，这样我们随机挑选一个下标对应的元素并验证，有很大的概率能找到众数。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        private int randRange(Random rand, int min, int max) {
            return rand.nextInt(max - min) + min;
        }

        private int countOccurences(int[] nums, int num) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        public int majorityElement(int[] nums) {
            Random rand = new Random();

            int majorityCount = nums.length / 2;

            while (true) {
                int candidate = nums[randRange(rand, 0, nums.length)];
                if (countOccurences(nums, candidate) > majorityCount) {
                    return candidate;
                }
            }
        }
    }
}
