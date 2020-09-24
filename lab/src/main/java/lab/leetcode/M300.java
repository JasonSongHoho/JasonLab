package lab.leetcode;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * @author jasonsong
 * 2020/9/23
 */


public class M300 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS1(new int[]{10}));
        System.out.println(lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * DP
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            for (int j = 0; j < i; j++) {
                if (v > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 贪心 + 分治
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] tail = new int[n];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < n; i++) {
            int v = nums[i];
            if (v > tail[end]) {
                tail[++end] = v;
            } else {
                int l = 0, r = end, m;
                while (l < r) {
                    m = l + (r - l) / 2;
                    if (v > tail[m]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                tail[l] = v;
            }
        }
        return end + 1;
    }

    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution {
        public static int lengthOfLIS(int[] nums) {
            int len = nums.length;
            if (len <= 1) {
                return len;
            }

            // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
            int[] tail = new int[len];
            // 遍历第 1 个数，直接放在有序数组 tail 的开头
            tail[0] = nums[0];
            // end 表示有序数组 tail 的最后一个已经赋值元素的索引
            int end = 0;

            for (int i = 1; i < len; i++) {
                // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
                if (nums[i] > tail[end]) {
                    // 直接添加在那个元素的后面，所以 end 先加 1
                    end++;
                    tail[end] = nums[i];
                } else {
                    // 使用二分查找法，在有序数组 tail 中
                    // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                    int left = 0;
                    int right = end;
                    while (left < right) {
                        // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                        // int mid = left + (right - left) / 2;
                        int mid = left + ((right - left) / 2);
                        if (tail[mid] < nums[i]) {
                            // 中位数肯定不是要找的数，把它写在分支的前面
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                    // 因此，无需再单独判断
                    tail[left] = nums[i];
                }
                // 调试方法
                // printArray(nums[i], tail);
            }
            // 此时 end 是有序数组 tail 最后一个元素的索引
            // 题目要求返回的是长度，因此 +1 后返回
            end++;
            return end;
        }

        public static void main(String[] args) {
//            int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
            int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
            Solution solution = new Solution();
            int lengthOfLIS = Solution.lengthOfLIS(nums);
            System.out.println("最长上升子序列的长度：" + lengthOfLIS);
        }

        // 调试方法，以观察是否运行正确
        private void printArray(int num, int[] tail) {
            System.out.print("当前数字：" + num);
            System.out.print("\t当前 tail 数组：");
            int len = tail.length;
            for (int i = 0; i < len; i++) {
                if (tail[i] == 0) {
                    break;
                }
                System.out.print(tail[i] + ", ");
            }
            System.out.println();
        }
    }


}
