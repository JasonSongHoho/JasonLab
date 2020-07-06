package lab.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author jasonsong
 * 2020/7/5
 */


public class M567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("a", "ab"));
        //true start:3,end:4
        System.out.println(checkInclusion("ab", "eidbaooo"));
        //false
        System.out.println(checkInclusion("ab", "eidboaoo"));
        //false
        System.out.println(checkInclusion("aabcc", "dabdabc"));
        //true start:1,end:5
        System.out.println(checkInclusion("aabcc", "dcabacca"));
        //true start:2,end:7
        System.out.println(checkInclusion("aabcc", "dcabcca"));
        //false
        System.out.println(checkInclusion("aabccb", "dacabcca"));
        //true start:3,end:8
        System.out.println(checkInclusion("aabccb", "dacabccaba"));
    }

    /**
     * 桶排序 + 滑动窗口
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 1) {
            return s2.contains(s1);
        }
        Map<Character, Integer> map = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        Map<Character, Integer> cacheMap = new HashMap<>(map);
        int start = -1;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                map = new HashMap<>(cacheMap);
                start = -1;
                continue;
            }
            if (count > 0) {
                map.put(c, --count);
                if (start < 0) {
                    start = i;
                } else if (i - start + 1 == s1.length()) {
                    System.out.println("start:" + start + ",end:" + i);
                    return true;
                }
            } else {
                for (int j = start; j < i; j++) {
                    char charJ = s2.charAt(j);
                    if (charJ == c) {
                        start = j + 1;
                        break;
                    } else {
                        Integer count1 = map.get(charJ);
                        map.put(charJ, ++count1);
                    }
                }
            }
        }
        return false;
    }


}
