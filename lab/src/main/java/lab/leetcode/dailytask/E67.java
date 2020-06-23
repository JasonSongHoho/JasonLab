package lab.leetcode.dailytask;

import java.util.Stack;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * @author jasonsong
 * 2020/6/23
 */


public class E67 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("0", "0"));
        System.out.println(addBinary("0", "1"));
    }

    public static String addBinary1(String a, String b) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        for (char ca : charsA) {
            stackA.push(Integer.valueOf(String.valueOf(ca)));
        }
        for (char cb : charsB) {
            stackB.push(Integer.valueOf(String.valueOf(cb)));
        }
        StringBuilder result = new StringBuilder();
        Integer last = 0;
        Integer itemSum;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            Integer intA = 0;
            Integer intB = 0;
            if (!stackA.isEmpty()) {
                intA = stackA.pop();
            }
            if (!stackB.isEmpty()) {
                intB = stackB.pop();
            }
            itemSum = intA + intB + last;
            last = itemSum / 2;
            itemSum = itemSum % 2;
            result.insert(0, itemSum);
        }
        if (last > 0) {
            result.insert(0, last);
        }

        return result.toString();
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        Integer last = 0;
        Integer itemSum;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
            Integer intA = 0;
            Integer intB = 0;
            if (i>=0){
                intA=Integer.valueOf(String.valueOf(a.charAt(i)));
                i--;
            }
            if (j>=0) {
                intB = Integer.valueOf(String.valueOf(b.charAt(j)));
                j--;
            }
            itemSum = intA + intB + last;
            last = itemSum / 2;
            itemSum = itemSum % 2;
            result.insert(0, itemSum);
        }

        if (last > 0) {
            result.insert(0, last);
        }
        return result.toString();
    }


}
