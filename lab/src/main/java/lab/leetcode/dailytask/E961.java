package lab.leetcode.dailytask;

import java.util.HashSet;
import java.util.Random;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 104
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 *
 * @author Jason/XiaoJie
 * @date 2022/5/21
 */
public class E961 {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/solution/zai-chang-du-2n-de-shu-zu-zhong-zhao-chu-w88a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)O(n)。我们最多对数组进行三次遍历（除了 n=2n=2 之外，最多两次遍历）。
     * <p>
     * 空间复杂度：O(1)O(1)。
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes2(int[] nums) {
        int n = nums.length;
        for (int gap = 1; gap <= 3; ++gap) {
            for (int i = 0; i + gap < n; ++i) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        // 不可能的情况
        return -1;
    }

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：期望 O(1)。选择两个相同元素的概率为 (n/2n) * (n-1)/2n ≈ 1/4，因此期望 4 次结束循环。
     * <p>
     * 空间复杂度：O(1)。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/solution/zai-chang-du-2n-de-shu-zu-zhong-zhao-chu-w88a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes3(int[] nums) {
        int n = nums.length;
        Random random = new Random();

        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }


}
