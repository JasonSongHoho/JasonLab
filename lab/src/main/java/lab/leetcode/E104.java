package lab.leetcode;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * @author jasonsong
 * 2020/6/15
 */


public class E104 {

    public static void main(String[] args) {
        System.out.println(maxDepth(TreeSerialize.deserialize("[3,9,20,null,null,15,7]")));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int depth1 = 0, depth2 = 0;
        if (root.left != null) {
            depth1 = maxDepth(root.left);
        }
        if (root.right != null) {
            depth2 = maxDepth(root.right);
        }
        depth += Math.max(depth1, depth2);
        return depth;
    }

    private int maxLen = 0;
    public int maxDepth1(TreeNode root) {
        maxLen = 0;
        recur(root, 0);
        return maxLen;
    }

    private void recur(TreeNode node, int depth) {
        if (node == null) {
            maxLen = Math.max(maxLen, depth);
            return;
        }
        recur(node.left, depth + 1);
        recur(node.right, depth + 1);
    }


}
