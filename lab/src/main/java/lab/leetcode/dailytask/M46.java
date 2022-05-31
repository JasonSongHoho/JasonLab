package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/31
 */
public class M46 {
    static List<List<Integer>> ans;

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(new ArrayList<>(), numsList);
        return ans;
    }

    private static void dfs(List<Integer> list, List<Integer> leftNums) {
        int n = leftNums.size();
        if (n == 0) {
            ans.add(list);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> subList = new ArrayList<>(list);
            List<Integer> subLeftList = new ArrayList<>(leftNums);
            subList.add(leftNums.get(i));
            subLeftList.remove(i);
            dfs(subList, subLeftList);
        }
    }

}
