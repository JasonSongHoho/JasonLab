package lab.leetcode.dailytask;

/**
 *
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 *
 *
 * @author jasonsong
 * 2020/8/3
 */


public class E415 {

    public String addStrings(String num1, String num2) {
        int temp = 0;
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(j);
            int total = temp + c1 - '0' + c2 - '0';
            temp = total / 10;
            result.append(total % 10);
        }
        for (; i >= 0; i--) {
            int total = temp + num1.charAt(i) - '0';
            temp = total / 10;
            result.append(total % 10);
        }
        for (; j >= 0; j--) {
            int total = temp + num2.charAt(j) - '0';
            temp = total / 10;
            result.append(total % 10);
        }
        if (temp > 0) {
            result.append(temp);
        }
        return result.reverse().toString();
    }

}
