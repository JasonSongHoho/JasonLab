package lab.leetcode.dailytask;

import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author jasonsong
 * 2020/9/11
 */


public class M216 {
    static List<List<Integer>> result;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        result = new LinkedList<>();
        recur(k, n, 1, new LinkedList<>());
        return result;
    }

    private static void recur(int k, int n, int index, List<Integer> item) {
        for (int i = index; i <= 9; i++) {
            List<Integer> temp = new LinkedList<>(item);
            if (n < i || k == 0) {
                return;
            } else if (n == i && k == 1) {
                temp.add(i);
                result.add(temp);
                return;
            } else {
                temp.add(i);
                recur(k - 1, n - i, i + 1, temp);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

}
