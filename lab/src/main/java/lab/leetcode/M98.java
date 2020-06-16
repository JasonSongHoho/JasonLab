package lab.leetcode;

import lab.leetcode.common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * [3,1,5,0,2,4,6]
 * <p>
 * [-2147483648,-2147483648]
 *
 * @author jasonsong
 * 2020/6/15
 */


public class M98 {
    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(-2147483648);
        TreeNode root110 = new TreeNode(-2147483648);
        root1.left = root110;
        TreeNode root = new TreeNode(3);
        TreeNode node10 = new TreeNode(1);
        TreeNode node11 = new TreeNode(5);
        TreeNode node20 = new TreeNode(0);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(4);
        TreeNode node23 = new TreeNode(6);
        root.left = node10;
        root.right = node11;
        node10.left = node20;
        node10.right = node21;
        node11.left = node22;
        node11.right = node23;

        System.out.println(isValidBST(root));

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidNode(root, null, null);
    }

    public static boolean isValidNode(TreeNode treeNode, Integer topBound, Integer bottomBound) {
        if (topBound != null && topBound <= treeNode.val) {
            return false;
        }
        if (bottomBound != null && bottomBound >= treeNode.val) {
            return false;
        }
        if (treeNode.left != null && !isValidNode(treeNode.left, treeNode.val, bottomBound)) {
            return false;
        }
        if (treeNode.right != null && !isValidNode(treeNode.right, topBound, treeNode.val)) {
            return false;
        }
        return true;
    }

}

