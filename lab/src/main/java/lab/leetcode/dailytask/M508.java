package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * -105 <= Node.val <= 105
 *
 * @author Jason/XiaoJie
 * @date 2022/6/19
 */
@Slf4j
public class M508 {

    static Map<Integer, Integer> cnt = new HashMap<>();

    public static void main(String[] args) {
        log.info("{}", findFrequentTreeSum(TreeSerialize.deserialize("[5,2,-3]")));
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        return getMaxNums();
    }

    private static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int val = node.val + dfs(node.left) + dfs(node.right);
        cnt.put(val, cnt.getOrDefault(val, 0) + 1);
        return val;
    }

    private static int[] getMaxNums() {
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v == max) {
                ans.add(k);
            } else if (v > max) {
                max = v;
                ans = new ArrayList<>();
                ans.add(k);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
