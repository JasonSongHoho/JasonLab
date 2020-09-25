package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * @author jasonsong
 * 2020/9/26
 */


public class M113 {
    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        path = new LinkedList<>();
        dfs(root, sum);
        return result;
    }

    private void dfs(TreeNode node, int current) {
        if (node != null) {
            int val = node.val;
            path.add(val);
            current -= val;
            if (current == 0 && node.left == null && node.right == null) {
                result.add(new LinkedList<>(path));
            } else {
                dfs(node.left, current);
                dfs(node.right, current);
            }
            path.removeLast();
        }
    }

}
