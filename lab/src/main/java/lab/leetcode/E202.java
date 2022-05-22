package lab.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 *
 * @author Jason/XiaoJie
 * @date 2022/5/22
 */
public class E202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int r = n;
        int temp;
        int x;
        while (!set.contains(r)) {
            if (r == 1) {
                return true;
            }
            set.add(r);
            temp = 0;
            while (r > 0) {
                x = r % 10;
                temp += x * x;
                r = r / 10;
            }
            r = temp;
        }
        return false;
    }
}
