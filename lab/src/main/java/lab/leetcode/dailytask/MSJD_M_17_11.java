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
//        List<Integer> positionList1 =  new ArrayList<>(Arrays.asList(1,3,5));
//
//        int i1 = Collections.binarySearch(positionList1, 2);
//        System.out.println(i1);
//        System.out.println(Collections.binarySearch(positionList1, 4));

        System.out.println("" + findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "from"));
    }

    public static int findClosest(String[] words, String word1, String word2) {
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
}
