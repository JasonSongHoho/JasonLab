package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * @author Jason/XiaoJie
 * @date 2022/5/23
 */
public class E965 {
    public static void main(String[] args) {

    }

    public static boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> temp;
        deque.push(root);
        while (!deque.isEmpty()) {
            temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                if (node.val != val) {
                    return false;
                }
                if (node.right != null) {
                    temp.push(node.right);
                }
                if (node.left != null) {
                    temp.push(node.left);
                }
            }
            deque = temp;
        }
        return true;
    }
}
