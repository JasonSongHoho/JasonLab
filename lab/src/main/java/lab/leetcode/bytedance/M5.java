package lab.leetcode.bytedance;

/**
 * @author jasonsong
 * 2020/8/17
 */


public class M5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("ccd"));
        System.out.println(longestPalindrome("dcc"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int left = (length - 1) / 2;
        int right = left + 1;
        String ans = "";
        String temp;
        int max = 0;
        while (2 * left + 2 > max || 2 * (length - right) > max) {
            if (2 * left + 1 > max) {
                temp = isPalindrome(s, left, left);
                if (temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
            if (2 * left + 2 > max) {
                temp = isPalindrome(s, left, left + 1);
                if (temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
            if (2 * (length - right) - 1 > max) {
                temp = isPalindrome(s, right, right);
                if (temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
            if (2 * (length - right) > max) {
                temp = isPalindrome(s, right, right + 1);
                if (temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
            left--;
            right++;
        }
        return ans;
    }

    private static String isPalindrome(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(++left, right);
    }

}
