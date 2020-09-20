package lab.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 通过次数64,049提交次数124,541
 *
 * @author jasonsong
 * 2020/9/19
 */


public class H60 {
    public String getPermutation(int n, int k) {
        List<Integer> rest = new ArrayList<>();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            rest.add(i);
            nums[i] = nums[i - 1] * i;
        }
        StringBuilder str = new StringBuilder();
        k--;
        for (int i = n; i >= 1; i--) {
            int index = k / nums[i - 1];
            k = k % nums[i - 1];
            str.append(rest.remove(index));
        }
        return str.toString();
    }

}
