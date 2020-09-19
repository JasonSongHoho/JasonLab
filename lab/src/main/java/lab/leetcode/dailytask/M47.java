package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/18
 */


public class M47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}).toString());
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        recur(result, nums, 0, visit, new LinkedList<>());
        return result;
    }

    private static void recur(List<List<Integer>> result, int[] nums, int index, boolean[] visit, LinkedList<Integer> item) {
        int length = nums.length;
        if (index == length) {
            result.add(new LinkedList<>(item));
        } else {
            for (int i = 0; i < length; i++) {
                if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                    continue;
                } else {
                    visit[i] = true;
                    item.add(nums[i]);
                    recur(result, nums, index + 1, visit, item);
                    visit[i] = false;
                    item.removeLast();
                }
            }
        }
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution {
        public static void main(String[] args) {
            System.out.println(permuteUnique(new int[]{1, 1, 2}).toString());
        }

        public static List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> perm = new ArrayList<Integer>();
            boolean[] vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, ans, 0, vis, perm);
            return ans;
        }

        public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, boolean[] vis, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                } else {
                    perm.add(nums[i]);
                    vis[i] = true;
                    backtrack(nums, ans, idx + 1, vis, perm);
                    vis[i] = false;
                    perm.remove(idx);
                }
            }
        }
    }
//
//
//    private List<List<Integer>> result;
//    private Set<String> set;
//
//    public List<List<Integer>> permuteUnique1(int[] nums) {
//        result = new ArrayList<>();
//        set = new HashSet<>();
//        List<Integer> rest = new LinkedList<>();
//        for (int i : nums) {
//            rest.add(i);
//        }
//        recur(new LinkedList<>(), rest);
//        return result;
//    }
//
//    private void recur(List<Integer> visited, List<Integer> rest) {
//        if (rest.isEmpty()) {
//            StringBuilder key = new StringBuilder();
//            for (Integer i : visited) {
//                key.append(i).append(",");
//            }
//            if (!set.contains(key.toString())) {
//                result.add(visited);
//                set.add(key.toString());
//            }
//            return;
//        }
//        for (Integer i : rest) {
//            List<Integer> newVisited = new LinkedList<>(visited);
//            List<Integer> newRest = new LinkedList<>(rest);
//            newVisited.add(i);
//            newRest.remove(i);
//            recur(newVisited, newRest);
//        }
//    }

}
