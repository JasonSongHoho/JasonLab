package lab.leetcode;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.Stack;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author jasonsong
 * 2020/6/18
 */


public class E101 {
    public static void main(String[] args) {
        String data = "[9,25,25,null,-95,-95,null,-100,null,null,-100]";
        TreeNode treeNode = TreeSerialize.deserialize(data);
        System.out.println(isSymmetric1(treeNode));
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isLegalTree(root, root);
    }

    private static boolean isLegalTree(TreeNode left, TreeNode right) {
        if (left.val != right.val) {
            return false;
        }
        if (left.left != null && right.right != null) {
            if (!isLegalTree(left.left, right.right)) {
                return false;
            }
        } else if (!(left.left == null && right.right == null)) {
            return false;
        }
        if (left.right != null && right.left != null) {
            if (!isLegalTree(left.right, right.left)) {
                return false;
            }
        } else if (!(left.right == null && right.left == null)) {
            return false;
        }
        return true;
    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        treeNodeStack1.push(root);
        while (!treeNodeStack.isEmpty()) {
            TreeNode treeNode = treeNodeStack.pop();
            TreeNode treeNode1 = treeNodeStack1.pop();
            if (treeNode.val != treeNode1.val) {
                return false;
            }
            TreeNode right = treeNode.right;
            TreeNode left = treeNode.left;
            TreeNode right1 = treeNode1.right;
            TreeNode left1 = treeNode1.left;
            if (right != null && left1 != null) {
                treeNodeStack.push(right);
                treeNodeStack1.push(left1);
            } else if (!(left1 == null && right == null)) {
                return false;
            }

            if (right1 != null && left != null) {
                treeNodeStack.push(left);
                treeNodeStack1.push(right1);
            } else if (!(left == null && right1 == null)) {
                return false;
            }
        }
        return true;
    }

}