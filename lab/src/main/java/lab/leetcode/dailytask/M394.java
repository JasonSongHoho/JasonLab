package lab.leetcode.dailytask;

import javafx.util.Pair;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/22
 */
public class M394 {

    static char startNum = '0', endNum = '9', startLetter = 'a', endLetter = 'z';

    public static String decodeString(String s) {
        Pair<StringBuilder, Integer> pair = dfs(s, 0, 1);
        return pair.getKey().toString();
    }

    public static Pair<StringBuilder, Integer> dfs(String s, int l, int times) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int i = l;
        for (; i < s.length(); ) {
            char c = s.charAt(i);
            if (c >= startLetter && c <= endLetter) {
                sb.append(c);
                i++;
            } else if (c >= startNum && c <= endNum) {
                StringBuilder numStr = new StringBuilder("" + c);
                while (s.charAt(i + 1) >= startNum && s.charAt(i + 1) <= endNum) {
                    numStr.append(s.charAt(i + 1));
                    i++;
                }
                try {
                    int num = Integer.parseInt(numStr.toString());
                    Pair<StringBuilder, Integer> pair = dfs(s, i + 1, num);
                    sb.append(pair.getKey());
                    i = pair.getValue();
                } catch (Exception e) {
                }
            } else if (c == ']') {
                i++;
                break;
            } else {
                i++;
            }
        }
        for (int j = 0; j < times; j++) {
            result.append(sb);
        }
        return new Pair<>(result, i);
    }

    public static void main(String[] args) {
        String decodeString = decodeString("3[ax]2[bc]");
        System.out.println(decodeString);
    }
}
