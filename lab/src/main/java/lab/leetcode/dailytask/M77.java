package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/9
 */


public class M77 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recur(n, k, 0, new ArrayList<>());
        return result;
    }

    private void recur(int n, int k, int index, List<Integer> item) {
        for (int i = index; i < n; i++) {
            List<Integer> temp = new ArrayList<>(item);
            temp.add(i);
            if (temp.size() == k) {
                result.add(temp);
            } else {
                recur(n, k, i, item);
            }
        }
    }

}
