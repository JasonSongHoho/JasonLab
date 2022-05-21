package lab.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author Jason/XiaoJie
 * @date 2022/5/21
 */
@Slf4j
public class M5 {
    int len;
    int maxLen;
    String resultStr = "";

    public static void main(String[] args) {
        String testText1 = "aaa";
        String testText2 = "aaaa";
        String testText3 = "aaaaa";
        String testText4 = "acxca";
        String testText5 = "abc";
        String testText6 = "aba";
        String testText7 = "abbd";
        String testText8 = "ccd";
        String testText9 = "cdd";
        log.info("test {}, result: {}", testText1, new M5().longestPalindrome(testText1));
        log.info("test {}, result: {}", testText2, new M5().longestPalindrome(testText2));
        log.info("test {}, result: {}", testText3, new M5().longestPalindrome(testText3));
        log.info("test {}, result: {}", testText4, new M5().longestPalindrome(testText4));
        log.info("test {}, result: {}", testText5, new M5().longestPalindrome(testText5));
        log.info("test {}, result: {}", testText6, new M5().longestPalindrome(testText6));
        log.info("test {}, result: {}", testText7, new M5().longestPalindrome(testText7));
        log.info("test {}, result: {}", testText8, new M5().longestPalindrome(testText8));
        log.info("test {}, result: {}", testText9, new M5().longestPalindrome(testText9));

    }

    public String longestPalindrome(String s) {
        len = s.length();
        if (len == 1) {
            return s;
        }
        if (len == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        maxLen = 1;
        resultStr = s.substring(0, 1);
        for (int i = (len - 1) / 2, j = i + 1; (i >= 0 || j < len) && ((i + 1) * 2 > maxLen || (len - j + 1) * 2 > maxLen); i--, j++) {
            if ((i + 1) * 2 > maxLen) {
                compare(i, i, s);
                compare(i, i + 1, s);
            }
            if ((len - j + 1) * 2 > maxLen) {
                compare(j, j, s);
                compare(j - 1, j, s);
            }
        }
        return resultStr;
    }

    private void compare(int l, int r, String s) {
        while (l >= 0 && r < len) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        l++;
        r--;
        if (r - l + 1 > maxLen) {
            maxLen = r - l + 1;
            resultStr = s.substring(l, r + 1);
        }
    }
}
