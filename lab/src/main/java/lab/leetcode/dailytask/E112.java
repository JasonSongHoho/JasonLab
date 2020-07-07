package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @author jasonsong
 * 2020/7/7
 */


public class E112 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeSerialize.deserialize("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(hasPathSum(treeNode, 23));
        TreeNode treeNode1 = TreeSerialize.deserialize("[-2,null,-3]");
        System.out.println(hasPathSum(treeNode1, -5));

    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        if (root.left != null) {
            boolean hasPathSum = hasPathSum(root.left, sum - root.val);
            if (hasPathSum) {
                return true;
            }
        }
        if (root.right != null) {
            boolean hasPathSum = hasPathSum(root.right, sum - root.val);
            if (hasPathSum) {
                return true;
            }
        }
        return false;
    }

//    private static boolean helper(TreeNode root, int sum) {
//        if (root==null){
//            return false;
//        }
//        if (root)
//        return false;
//    }

}
