package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 * @author jasonsong
 * 2020/9/8
 */


public class M144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        } else {
            result.add(node.val);
        }
        if (node.left != null) {
            dfs(node.left, result);
        }
        if (node.right != null) {
            dfs(node.right, result);
        }
    }

}
