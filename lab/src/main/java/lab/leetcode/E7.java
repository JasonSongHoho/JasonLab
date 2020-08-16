package lab.leetcode;

/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 * @author jasonsong
 * 2020/8/14
 */


public class E7 {
    public static void main(String[] args) {

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int maxValueEnd = Integer.MAX_VALUE % 10;
        int minValueEnd = Integer.MIN_VALUE % 10;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > maxValueEnd)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < minValueEnd)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static int reverse1(int x) {
        String reverseString = new StringBuilder("" + x).reverse().toString();
        if (x < 0) {
            reverseString = "-" + reverseString.substring(0, reverseString.length() - 1);
        }
        long longValue = Long.parseLong(reverseString);
        if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) longValue;
        }
    }
}
