package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @author jasonsong
 * 2020/9/19
 */


public class E404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        return recur(root);
    }

    private int recur(TreeNode node){
        int total = 0;
        if(node.left != null){
            if(node.left.left == null && node.left.right == null){
                total += node.left.val;
            } else {
                total += recur(node.left);
            }
        }
        if(node.right != null){
            total += recur(node.right);
        }
        return total;
    }

}
