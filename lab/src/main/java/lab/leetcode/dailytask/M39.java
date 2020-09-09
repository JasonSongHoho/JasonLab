package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 *
 *
 * @author jasonsong
 * 2020/9/9
 */


public class M39 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        recur(new ArrayList<>(), 0, candidates, target);
        return result;
    }

    private void recur(List<Integer> item, int index, int[] candidates, int target) {
        if (target < candidates[0]) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                List<Integer> temp = new ArrayList<>(item);
                int candidate = candidates[i];
                if (target == candidate) {
                    temp.add(candidate);
                    result.add(temp);
                    return;
                } else if (target > candidate) {
                    temp.add(candidate);
                    recur(temp, i, candidates, target - candidate);
                } else {
                    return;
                }
            }
        }
    }
}
