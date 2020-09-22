package lab.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author jasonsong
 * 2020/7/19
 */


public class M93 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses1("255255111135"));
        System.out.println(restoreIpAddresses("010010"));
        System.out.println(restoreIpAddresses1("25525511135"));
    }


    public static List<String> restoreIpAddresses(String s) {
        int length = s.length();
        List<String> result = new ArrayList<>();
        if (length < 4 || length > 12) {
            return result;
        }
        for (int i = Math.max(1, length - 9); i < 4 && i < length - 2; i++) {
            String s1 = s.substring(0, i);
            if (!canPass(s1)) {
                continue;
            }
            for (int j = Math.max(i + 1, length - 6); j < i + 4 && j < length - 1; j++) {
                String s2 = s.substring(i, j);
                if (!canPass(s2)) {
                    continue;
                }
                for (int k = Math.max(j + 1, length - 3); k < j + 4 && k < length; k++) {
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, length);
                    if (canPass(s3) && canPass(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }

                }
            }
        }
        return result;
    }

    private static boolean canPass(String str) {
        if (str.length() > 1 && str.startsWith("0")) {
            return false;
        }
        int value = Integer.valueOf(str);
        return value <= 255;
    }


    public static List<String> restoreIpAddresses1(String s) {
        int length = s.length();
        if (length > 12 || length < 4) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        for (int i = Math.max(length - 9, 1); i <= 3; i++) {
            String s1 = s.substring(0, i);
            if ((s1.length() >= 2 && s1.startsWith("0")) || Integer.valueOf(s1) > 255) {
                continue;
            }
            for (int j = Math.max(length - 6, i + 1); j <= i + 3 && j <= length - 2; j++) {
                String s2 = s.substring(i, j);
                if ((s2.length() >= 2 && s2.startsWith("0")) || Integer.valueOf(s2) > 255) {
                    continue;
                }
                for (int k = Math.max(length - 3, j + 1); k <= j + 3 && k <= length - 1; k++) {
                    if (length - k > 3) {
                        continue;
                    }
                    String s3 = s.substring(j, k);
                    if ((s3.length() >= 2 && s3.startsWith("0")) || Integer.valueOf(s3) > 255) {
                        continue;
                    }
                    String s4 = s.substring(k, length);
                    if ((s4.length() < 2 || !s4.startsWith("0")) && Integer.valueOf(s4) <= 255) {
                        //此处使用 StringBuilder ,会大大提升时间复杂度。
                        //可更换为 result.add(s1+"."+s2+"."+s3+"."+s4); 自行验证
                        result.add(new StringBuilder(s1).append(".").append(s2).append(".").append(s3).append(".").append(s4).toString());
                    }
                }
            }
        }

        return result;
    }
}
