package lab.leetcode.dailytask;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 * @author jasonsong
 * 2020/9/11
 */


public class M40 {
    List<List<Integer>> result;
    Set<String> visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new LinkedList<>();
        visited = new HashSet<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        recur(candidates, target, 0, new LinkedList<>());
        return result;
    }

    private void recur(int[] candidates, int target, int index, List<Integer> item) {
        int l = candidates.length;
        for (int i = index; i < l; i++) {
            int candidate = candidates[i];
            List<Integer> temp = new LinkedList<>(item);
            if (target < candidate) {
                return;
            } else if (target == candidate) {
                temp.add(candidate);
                String str = generateString(temp);
                if (!visited.contains(str)) {
                    visited.add(str);
                    result.add(temp);
                }
                return;
            } else {
                temp.add(candidate);
                recur(candidates, target - candidate, i + 1, temp);
            }
        }
    }

    private String generateString(List<Integer> item) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : item) {
            sb.append(i);
        }
        return sb.toString();
    }
}
