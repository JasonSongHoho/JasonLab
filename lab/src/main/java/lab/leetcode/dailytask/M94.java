package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @author jasonsong
 * 2020/9/15
 */


public class M94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        return dfs(root, list);
    }
    private List<Integer> dfs(TreeNode node, List<Integer> list){
        if(node == null){
            return list;
        } else {
            list = dfs(node.left, list);
            list.add(node.val);
            list = dfs(node.right, list);
            return list;
        }
    }
}
