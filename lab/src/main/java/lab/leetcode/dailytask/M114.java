package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 * @author jasonsong
 * 2020/8/2
 */


public class M114 {
    public static void main(String[] args) {
        TreeNode root = TreeSerialize.deserialize("[1,2,5,3,4,null,6]");
        flatten(root);

    }

    /**
     * my wrong answer
     */
    public static void flatten(TreeNode root) {
        TreeNode listTree = new TreeNode();
        recursiveFunction(root, listTree);
        root = listTree;
        System.out.println(root);
    }

    private static TreeNode recursiveFunction(TreeNode treeNode, TreeNode listTree) {
        if (treeNode != null) {
            listTree.val = treeNode.val;
            listTree.right = new TreeNode();
        }
        if (treeNode.left != null) {
            listTree = recursiveFunction(treeNode.left, listTree.right);
        }
        if (treeNode.right != null) {
            listTree = recursiveFunction(treeNode.right, listTree.right);
        }
        return listTree;
    }


}


/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/er-cha-shu-zhan-kai-wei-lian-biao-by-leetcode-solu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution0 {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
