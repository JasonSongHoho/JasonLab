package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * @author jasonsong
 * 2020/10/13
 */


public class E530 {
    int minResult;
    int pre;
    public int getMinimumDifference(TreeNode root) {
        minResult = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return minResult;
    }

    private void dfs(TreeNode tree){
        if(tree != null){
            dfs(tree.left);
            if(pre != -1){
                minResult = Math.min(minResult, tree.val - pre);
                if(minResult == 0){
                    return;
                }
            }
            pre = tree.val;
            dfs(tree.right);
        }
    }
}
