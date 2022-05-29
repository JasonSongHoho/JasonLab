package lab.leetcode;

/**
 * 461. 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x, y <= 231 - 1
 *
 * @author Jason/XiaoJie
 * @date 2022/5/30
 */
public class E576 {
    public int hammingDistance(int x, int y) {
        int temp = Math.abs(x ^ y), ans = 0;
        while (temp > 0) {
            ans += (temp & 1);
            temp >>= 1;
        }
        return ans;
    }

    /**
     * Brian Kernighan 算法
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode-solution-u1w7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance0(int x, int y) {
        int temp = Math.abs(x ^ y), ans = 0;
        while (temp > 0) {
            temp &= (temp - 1);
            ans++;
        }
        return ans;
    }
}
