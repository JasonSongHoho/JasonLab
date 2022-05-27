package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/27
 */
public class MSJD_M_17_11 {
    public static void main(String[] args) {

        System.out.println("" + findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "from"));
    }

    public static int findClosest1(String[] words, String word1, String word2) {
        List<Integer> positionList1 = new ArrayList<>();
        List<Integer> positionList2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                positionList1.add(i);
            } else if (words[i].equals(word2)) {
                positionList2.add(i);
            }
        }
        int distance = Integer.MAX_VALUE, p1;
        int len = positionList2.size();
        for (Integer integer : positionList1) {
            p1 = integer;
            int i1 = Collections.binarySearch(positionList2, p1);
            int t1 = -1 - i1;
            int t2 = -2 - i1;
            if (t1 >= 0 && t1 < len) {
                distance = Math.min(distance, Math.abs(p1 - positionList2.get(t1)));
            }
            if (t2 >= 0 && t2 < len) {
                distance = Math.min(distance, Math.abs(p1 - positionList2.get(t2)));
            }
            if (distance == 1) {
                return 1;
            }
        }
        return distance;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/find-closest-lcci/solution/dan-ci-ju-chi-by-leetcode-solution-u96o/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public static int findClosest(String[] words, String word1, String word2) {
        int length = words.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }

}
