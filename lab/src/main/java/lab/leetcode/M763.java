package lab.leetcode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 注意:
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 *
 * @author jasonsong
 */
public class M763 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M763.class);

    public static void main(String[] args) {
        M763 m763 = new M763();
        String[] testStr = {"ahbgdh", "", "s","abcabdeefafghjhj"};
        for (String s : testStr) {
            LOGGER.info("input:{},output:{}", s, m763.partitionLabels(s));
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S.length() < 2) {
            result.add(S.length());
            return result;
        }
        int start = 0;
        int end = 0;
        int tmpEnd;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            tmpEnd = S.lastIndexOf(c);
            if (tmpEnd > end) {
                end = tmpEnd;
            }
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
