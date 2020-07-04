package lab.leetcode.dailytask;

import java.util.HashMap;
import java.util.Stack;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author jasonsong
 * 2020/7/4
 */


public class H32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(()()"));
        System.out.println(longestValidParentheses("()())()"));
        System.out.println(longestValidParentheses("()())())"));
        System.out.println(longestValidParentheses("(()())()"));
        System.out.println(longestValidParentheses("(()())())"));
    }

//                    if (lastIndex < 0) {
//        continue;
//    }else {
//        char last = s.charAt(lastIndex);
//        if (last==')'){
//            dp[i] = dp[i - 1];
//        }
//    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = i - 1;
            char c = s.charAt(i);
            if (c == '(') {
                if (lastIndex >= 0 && s.charAt(lastIndex) == ')') {
                    dp[i] = dp[i - 1];
                }
            } else {
                if (lastIndex < 0) {
                    continue;
                }
                char last = s.charAt(lastIndex);
                if (last == '(') {
                    dp[i] = dp[i - 1] + 2;
                } else if (dp[i - 1] > 0) {
                    lastIndex = i - dp[i - 1] - 1;
                    if (lastIndex < 0) {
                        continue;
                    } else {
                        last = s.charAt(lastIndex);
                        if (last == '(') {
                            dp[i] = dp[i - 1] + dp[lastIndex] + 2;
                        }
                    }
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    /**
     * 计数，左右各遍历一次
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses2(String s) {
        int result = 0;
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left << 1);
            } else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left << 1);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return result;
    }

    /**
     * 栈+数组
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses1(String s) {
        int result = 0;
        int currentLength = 0;
        int[] signArr = new int[s.length()];

        Stack<HashMap<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                HashMap<Character, Integer> hashMap = new HashMap<>(2);
                hashMap.put('(', i);
                stack.push(hashMap);
            } else {
                try {
                    HashMap<Character, Integer> pop = stack.pop();
                    signArr[i] = 1;
                    signArr[pop.get('(')] = 1;
                } catch (Exception e) {
                }
            }
        }
        for (int sign : signArr) {
            if (sign == 1) {
                currentLength++;
            } else {
                result = Math.max(result, currentLength);
                currentLength = 0;
            }
        }
        result = Math.max(result, currentLength);
        return result;
    }


}
