package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 *
 * @author jasonsong
 * 2020/9/4
 */


public class E257 {
    List<String> paths = new ArrayList<>();
    String symbol = "->";

    public List<String> binaryTreePaths(TreeNode root) {
        paths.clear();
        if (root != null) {
            dfs(root, "");
        }
        return paths;
    }

    private void dfs(TreeNode node, String path) {
        if (path.isEmpty()) {
            path = "" + node.val;
        } else {
            path = new StringBuilder(path).append(symbol).append(node.val).toString();
        }
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path);
        }
        if (node.right != null) {
            dfs(node.right, path);
        }
    }
}
