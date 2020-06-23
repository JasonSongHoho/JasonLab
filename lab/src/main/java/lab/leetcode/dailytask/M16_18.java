package lab.leetcode.dailytask;

import lombok.extern.slf4j.Slf4j;

/**
 * 面试题 16.18. 模式匹配
 * <p>
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），
 * 该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。
 * 编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 * <p>
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 *
 * @author jasonsong
 * 2020/6/22
 */

@Slf4j
public class M16_18 {
    public static void main(String[] args) {
        String pattern = "aaaa";
        String value = "dogcatcatdog";
        log.info("pattern: {},value:{}, result:{}", pattern, value, patternMatching(pattern, value));
        String pattern1 = "abba";
        String value1 = "dogcatcatfish";
        log.info("pattern: {},value:{}, result:{}", pattern1, value1, patternMatching(pattern1, value1));
        String pattern2 = "aaaa";
        String value2 = "dogcatcatdog";
        log.info("pattern: {},value:{}, result:{}", pattern2, value2, patternMatching(pattern2, value2));
        String pattern3 = "abba";
        String value3 = "dogdogdogdog";
        log.info("pattern: {},value:{}, result:{}", pattern3, value3, patternMatching(pattern3, value3));
        String pattern4 = "bbb";
        String value4 = "XXXXXX";
        log.info("pattern: {},value:{}, result:{}", pattern4, value4, patternMatching(pattern4, value4));
    }


    public static boolean patternMatching(String pattern, String value) {
        int valueLength = value.length();
        if (valueLength == 0) {
            return pattern.length() == 0 || !pattern.contains("b") || !pattern.contains("a");
        }
        if (pattern.length() == 0) {
            return false;
        }
        if (pattern.length() == 1) {
            return true;
        }

        Integer countA = 0;
        Integer countB = 0;
        char[] chars = pattern.toCharArray();
        for (char c : chars) {
            if (c == 'a') {
                countA++;
            } else {
                countB++;
            }
        }

        if (countA == 0) {
            if (valueLength % countB != 0) {
                return false;
            }
            return checkPattern(0, valueLength / countB, chars, value);
        }
        if (countB == 0) {
            if (valueLength % countA != 0) {
                return false;
            }
            return checkPattern(valueLength / countA, 0, chars, value);
        }

        for (Integer lengthA = 0, lengthB = (valueLength - countA * lengthA) / countB; lengthA <= valueLength && lengthB >= 0; ++lengthA, lengthB = (valueLength - countA * lengthA) / countB) {
            if (countA * lengthA + countB * lengthB != valueLength) {
                continue;
            }
            if (checkPattern(lengthA, lengthB, chars, value)) {
                return true;
            }

        }
        return false;

    }

    public static boolean checkPattern(Integer lengthA, Integer lengthB, char[] chars, String value) {
        String a = null;
        String b = null;
        for (char c : chars) {
            String tmp;
            if (c == 'a') {
                tmp = value.substring(0, lengthA);
                if (a == null) {
                    a = tmp;
                } else if (!a.equals(tmp)) {
                    return false;
                }
            } else {
                tmp = value.substring(0, lengthB);
                if (b == null) {
                    b = tmp;
                } else if (!b.equals(tmp)) {
                    return false;
                }
            }
            value = value.replaceFirst(tmp, "");
        }
        return true;
    }

}
