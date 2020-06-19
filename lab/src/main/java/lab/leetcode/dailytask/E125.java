package lab.leetcode.dailytask;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author jasonsong
 * 2020/6/19
 */


public class E125 {
    static int v0 = (int) '0';
    static int v9 = (int) '9';
    static int va = (int) 'a';
    static int vz = (int) 'z';
    static int vA = (int) 'A';
    static int vZ = (int) 'Z';

    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        boolean palindrome = isPalindrome(test1);
        System.out.println(palindrome);
        boolean palindrome2 = isPalindrome(test2);
        System.out.println(palindrome2);

    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int length = s.length();
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            char charI, charJ;
            while (true) {
                charI = s.charAt(i);
                Integer iValue = (int) charI;
                if (isStringOrNum(iValue)) {
                    break;
                } else if (++i >= j) {
                    return true;
                }
            }
            while (true) {
                charJ = s.charAt(j);
                Integer jValue = (int) charJ;
                if (isStringOrNum(jValue)) {
                    break;
                } else if (--j <= i) {
                    return true;
                }
            }
            System.out.println(String.valueOf(charI) + "--" + String.valueOf(charJ));

            if (Character.toLowerCase(charI) != (Character.toLowerCase(charJ))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStringOrNum(Integer cValue) {
        return ((cValue >= v0 && cValue <= v9) || (cValue >= va && cValue <= vz) || (cValue >= vA && cValue <= vZ));
    }
}
