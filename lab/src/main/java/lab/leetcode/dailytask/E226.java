package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * @author jasonsong
 * 2020/9/16
 */


public class E226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(0);
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, TreeNode result) {
        if (node != null) {
            result.val = node.val;
            if (node.left != null) {
                result.right = new TreeNode(0);
                dfs(node.left, result.right);
            }
            if (node.right != null) {
                result.left = new TreeNode(0);
                dfs(node.right, result.left);
            }
        } else {
            result = null;
        }
    }
}
