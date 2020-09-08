package lab.real.neteast;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jasonsong
 * 2020/9/8
 */


public class Test {
// 求最长不重复子串长度
// abcabcbb -> 3  (abc)
// bbbbb -> 1  (b)
// pwwkew - > 3 （wke）
//
    public static void main(String[] args) {

        System.out.println(getMaxSub("abcabcbb"));
        System.out.println(getMaxSub("bbbbb"));
        System.out.println(getMaxSub("pwwkew"));
    }

    public static int getMaxSub(String arg) {
        if (arg == null) {
            return 0;
        }
        char[] chars = arg.toCharArray();
        int maxLength = 0;
        StringBuilder temp = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int j = 0;
        int tempLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean contains = set.contains(c);
            if (!contains) {
                temp.append(c);
                tempLength++;
                set.add(c);
            } else {
                maxLength = Math.max(tempLength, maxLength);
                set.clear();
                tempLength = 0;
                i = ++j;
                temp = new StringBuilder();
            }

        }
        return maxLength;
    }
}
