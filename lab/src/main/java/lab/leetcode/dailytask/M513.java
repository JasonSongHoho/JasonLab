package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/22
 */
public class M513 {

    public int findBottomLeftValue(TreeNode root) {
        int ans = -1;
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> tmp;
        deque.offer(root);
        while (!deque.isEmpty()) {
            tmp = new LinkedList<>();
            ans = deque.peek().val;
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            deque = tmp;
        }
        return ans;
    }
}
