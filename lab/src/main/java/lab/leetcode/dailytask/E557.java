package lab.leetcode.dailytask;

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * @author jasonsong
 * 2020/8/30
 */


public class E557 {
    public static void main(String[] args) {
        System.out.println(reverseWords(""));
        System.out.println(reverseWords(null));
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return s;
        }
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                result.append(temp.reverse().toString()).append(" ");
                temp = new StringBuilder();
            } else {
                temp.append(c);
            }
        }
        return result.append(temp.reverse().toString()).toString();
    }
}
