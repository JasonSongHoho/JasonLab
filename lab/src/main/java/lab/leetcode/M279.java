package lab.leetcode;

/**
 * 279. 完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * https://leetcode.cn/problems/perfect-squares/
 *
 * @author Jason/XiaoJie
 * @date 2022/6/22
 */
public class M279 {
    public static int numSquares(int n) {
        if (isSquare(n)) {
            return 1;
        }
        if (isAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;

    }

    public static boolean isSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }

    public static boolean isAnswer4(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }
}
