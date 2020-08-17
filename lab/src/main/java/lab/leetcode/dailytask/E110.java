package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 *
 * @author jasonsong
 * 2020/8/17
 */


public class E110 {

    public static void main(String[] args) {
        System.out.println(isBalanced(TreeSerialize.deserialize("[3,9,20,null,null,15,7]")));
    }

    /**
     * https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight < 0) {
            return -1;
        }

        int rightHeight = height(root.right);
        if (rightHeight < 0 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }



    static Map<TreeNode, Integer> treeHeights = new HashMap<>();

    public int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getTreeNodeHeight(root);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int leftHeight;
        int rightHeight;
        while (stack.size() != 0) {
            TreeNode pop = stack.pop();
            if (pop.right != null) {
                stack.push(pop.right);
                rightHeight = treeHeights.get(pop.right);
            } else {
                rightHeight = 0;
            }
            if (pop.left != null) {
                stack.push(pop.left);
                leftHeight = treeHeights.get(pop.left);
            } else {
                leftHeight = 0;
            }
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
        }
        return true;
    }


    private static int getTreeNodeHeight(TreeNode treeNode) {
        TreeNode leftNode = treeNode.left;
        int leftHeight = 0;
        if (leftNode != null) {
            leftHeight = getTreeNodeHeight(leftNode);
            treeHeights.put(leftNode, leftHeight);
        }
        TreeNode rightNode = treeNode.right;
        int rightHeight = 0;
        if (rightNode != null) {
            rightHeight = getTreeNodeHeight(rightNode);
            treeHeights.put(rightNode, rightHeight);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
