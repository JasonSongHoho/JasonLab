package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/5
 */
public class M713 {


    public int numSubarrayProductLessThanK10(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return getSubArrayNum(list, k);
    }

    private int getSubArrayNum(List<Integer> nums, double k) {
        if (nums.size() == 0) {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = new ArrayList<>(nums);
            int num = list.get(i);
            list.remove(i);
            double newK = k / num;
            if (newK >= 1) {
                total += (1 + getSubArrayNum(list, newK));
            }
        }

        return total;
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-k-de-zi-shu-zu-by-leetc-92wl/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }


}
