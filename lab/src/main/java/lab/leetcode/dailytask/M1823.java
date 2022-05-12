package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.List;

/**
 * 共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。确切地说，从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
 * <p>
 * 游戏遵循如下规则：
 * <p>
 * 从第 1 名小伙伴所在位置 开始 。
 * 沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
 * 你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
 * 如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
 * 否则，圈子中最后一名小伙伴赢得游戏。
 * 给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jason/XiaoJie
 * @date 2022/5/4
 */
public class M1823 {

    /**
     * 数学 + 递归
     * 时间复杂度：O(n)O(n)，其中 nn 是做游戏的小伙伴数量。需要计算的值有 nn 个，每个值的计算时间都是 O(1)O(1)。
     * <p>
     * 空间复杂度：O(n)O(n)，其中 nn 是做游戏的小伙伴数量。空间复杂度主要取决于递归调用栈的深度，为 O(n)O(n) 层。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/zhao-chu-you-xi-de-huo-sheng-zhe-by-leet-w2jd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }


    /**
     * 数学 + 迭代
     * <p>
     * 时间复杂度：O(n)O(n)，其中 nn 是做游戏的小伙伴数量。需要 O(n)O(n) 的时间遍历并计算结果。
     * <p>
     * 空间复杂度：O(1)O(1)。
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner0(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }

    /**
     * 遍历
     * 时间 O(n)
     * 空间 O(n)
     *
     * @param n
     * @param k
     * @return
     */
    public int findTheWinner1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            int size = n - i;
            start = (k + start - 1) % size;
            list.remove(start);
        }
        return list.get(0);
    }


}
