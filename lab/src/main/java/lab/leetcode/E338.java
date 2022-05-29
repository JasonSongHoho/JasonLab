package lab.leetcode;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 *
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class E338 {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = bits[i >> 1] + bits[i & 1];
        }
        return bits;
    }

    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        int temp;
        for (int i = 0; i <= n; i++) {
            temp = i;
            while (temp > 0) {
                ans[i] += (temp & 1);
                temp = temp >> 1;
            }
        }
        return ans;
    }
}
