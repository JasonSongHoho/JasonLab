package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author jasonsong
 * 2020/9/26
 */


public class M106 {
    int[] inorder, postorder;
    int index;
    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        this.inorder = inorder;
        this.postorder = postorder;
        index = length - 1;
        indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return recur(0, index);
    }

    private TreeNode recur(int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[index--];
        TreeNode node = new TreeNode(val);
        int valIndex = indexMap.get(val);
        node.right = recur(valIndex + 1, right);
        node.left = recur(left, valIndex - 1);
        return node;
    }
}
