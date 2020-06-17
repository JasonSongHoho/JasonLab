package lab.leetcode.dailytask;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author jasonsong
 * 2020/6/10
 */

public class E9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12521));
//        System.out.println(isPalindrome(-121));
//        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String str = "" + x;
        int len = str.length();
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            if (i == j) {
                return true;
            } else {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        return y==x;
    }

}