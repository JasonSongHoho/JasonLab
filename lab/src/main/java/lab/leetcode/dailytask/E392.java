package lab.leetcode.dailytask;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 后续挑战 :
 * <p>
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢:
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 * @author jasonsong
 * 2020/7/27
 */


public class E392 {
    public static void main(String[] args) {
        //false
        System.out.println(isSubsequence("b", "c"));
        //true
        System.out.println(isSubsequence("abc", "ahbgdc"));
        //false
        System.out.println(isSubsequence("axc", "ahbgdc"));
        //true
        System.out.println(isSubsequence("aaaa", "bbaaaa"));
        //false
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
        //false
        System.out.println(isSubsequence("bb", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean isPattern = false;
            for (; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    j++;
                    isPattern = true;
                    break;
                }
            }
            int lessI = s.length() - i - 1;
            int lessJ = t.length() - j - 1;
            //S遍历完且最后一次匹配成功
            if (lessI == 0 && isPattern) {
                return true;
            }
            //T已经遍历完但是没有匹配到，或者T剩余的字符串已经不够匹配了
            if (!isPattern || lessJ < lessI - 1) {
                return false;
            }
        }
        return false;
    }

    /**
     * DP
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }


}
