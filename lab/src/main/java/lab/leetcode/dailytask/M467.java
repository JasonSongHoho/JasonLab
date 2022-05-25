package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 * <p>
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." .
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 * <p>
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
 * 示例 3:
 * <p>
 * 输入: p = "zab"
 * 输出: 6
 * 解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= p.length <= 105
 * p 由小写英文字母构成
 *
 * @author Jason/XiaoJie
 * @date 2022/5/25
 */
public class M467 {
    public int findSubstringInWraproundString(String p) {
        int len = p.length(), index, temp = 0;
        int[] dp = new int[26];
        char cur;
        for (int i = 0; i < len; i++) {
            cur = p.charAt(i);
            if (i > 0 && isNearWords(cur, p.charAt(i - 1))) {
                temp++;
            } else {
                temp = 1;
            }
            index = cur - 'a';
            dp[index] = Math.max(dp[index], temp);
        }
        return Arrays.stream(dp).sum();
    }

    public boolean isNearWords(char cur, char pre) {
        if (pre == 'z') {
            return cur == 'a';
        } else {
            return cur - pre == 1;
        }
    }
}
