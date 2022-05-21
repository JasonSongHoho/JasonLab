package lab.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author jasonsong
 * 2020/9/25
 */


public class M3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> flowWindow = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flowWindow.contains(c)) {
                max = Math.max(max, flowWindow.size());
                char c1;
                int index = i - flowWindow.size();
                while ((c1 = s.charAt(index)) != c) {
                    index++;
                    flowWindow.remove(c1);
                }
            }
            flowWindow.add(c);
        }
        max = Math.max(max, flowWindow.size());
        return max;
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 添加备注
     *
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 60.24%
     * 的用户
     * 内存消耗：
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 73.85%
     * 的用户
     * 通过测试用例：
     * 987 / 987
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int len = s.length();
        if (len == 1){
            return 1;
        }
        int maxLen = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for(int left = 0, right = 1; right < len; ){
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            maxLen = Math.max(maxLen, set.size());
            right++;
        }
        return maxLen;

    }

}
