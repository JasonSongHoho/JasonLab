package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jasonsong
 * 2020/10/22
 */


public class M763 {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    /**
     * 执行用时：
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 31.58%
     * 的用户
     *
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S) {
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        int length = S.length();
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            positionMap.put(c, i);
        }
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            Integer lastPosition = positionMap.get(c);
            end = Math.max(lastPosition, end);
            if (i == end) {
                result.add(end - start + 1);
                start = end = i + 1;
            }
        }


        return result;
    }

    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 96.93%
     * 的用户
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
