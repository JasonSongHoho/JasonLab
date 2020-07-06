package lab.leetcode.dailytask;

/**
 * 44. 通配符匹配
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 * <p>
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 * <p>
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 * <p>
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输出: false
 *
 * @author jasonsong
 * 2020/7/5
 */


public class H44 {

    public static void main(String[] args) {
//        System.out.println(isMatch1("adceb", "*a*b"));
//        System.out.println(isMatch1("aa", "*"));
        System.out.println(isMatch("adceb", "*a*b"));
    }

    /**
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/zi-fu-chuan-dong-tai-gui-hua-bi-xu-miao-dong-by-sw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */

    public static boolean isMatch1(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }


    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            } else {
                dp[i][0] = true;
            }
        }
        int lastStart = 1;
        for (int i = 1; i <= p.length(); i++) {
            char pc = p.charAt(i - 1);
            boolean haveTrue = false;
            if (dp[i][0]) {
                haveTrue = true;
            }
            //从上一次循环的第一个匹配点处开始
            for (int j = lastStart; j <= s.length(); j++) {
                char sc = s.charAt(j - 1);
                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
                if (!haveTrue && dp[i][j]) {
                    haveTrue = true;
                    lastStart = j;
                }
            }
            //如果整行都没有匹配到，直接返回 false
            if (!haveTrue) {
                return false;
            }
        }
        return dp[p.length()][s.length()];
    }
}
