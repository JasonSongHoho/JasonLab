package lab.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 *
 * @author Jason/XiaoJie
 * @date 2022/5/25
 */
public class M22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate("", n, n);
        return result;
    }

    private void generate(String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left == right) {
            generate(str + "(", left - 1, right);
        } else if (left < right) {
            if (left > 0) {
                generate(str + "(", left - 1, right);
            }
            generate(str + ")", left, right - 1);
        }
    }
}
