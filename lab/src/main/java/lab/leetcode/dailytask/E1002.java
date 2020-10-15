package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 *
 * @author jasonsong
 * 2020/10/14
 */


public class E1002 {
    public static void main(String[] args) {
        System.out.println(commonChars(new String[]{"bella", "label", "roller"}));
    }

    public static List<String> commonChars(String[] A) {
        Map<Character, Integer> pre = null;
        Map<Character, Integer> current = new HashMap<>();
        int length = A.length;

        for (int i = 0; i < length; i++) {
            String str = A[i];
            char[] chars = str.toCharArray();
            if (pre == null) {
                pre = new HashMap<>();
                for (char c : chars) {
                    Integer count = pre.getOrDefault(c, 0);
                    pre.put(c, ++count);
                }
            } else {
                current = new HashMap<>();
                for (char c : chars) {
                    Integer count = pre.getOrDefault(c, 0);
                    Integer currentCount = current.getOrDefault(c, 0);
                    if (count > currentCount) {
                        current.put(c, ++currentCount);
                    }
                }
                pre = current;
            }
        }
        List<String> result = new ArrayList<>();
        if (length == 1) {
            current = pre;
        }
        for (Map.Entry<Character, Integer> entry : current.entrySet()) {
            Integer integer = entry.getValue();
            Character key = entry.getKey();
            while (integer >= 1) {
                result.add("" + key);
                integer--;
            }
        }
        return result;
    }
}
