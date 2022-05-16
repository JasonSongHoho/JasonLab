package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 *
 * @author Jason/XiaoJie
 * @date 2022/5/16
 */
public class MSJD_M_04_06 {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/successor-lcci/solution/hou-ji-zhe-by-leetcode-solution-6hgc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }


    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        boolean findTarget = false;
        Deque<LoopNote> deque = new LinkedList<>();
        deque.push(new LoopNote(root, false));
        while (!deque.isEmpty()) {
            LoopNote note = deque.pop();
            TreeNode node = note.node;
            boolean readed = note.readed;
            if (readed) {
                if (findTarget) {
                    return node;
                }
                findTarget = (node.val == p.val && node.left == p.left && node.right == p.right);
                continue;
            }
            if (node.right != null) {
                deque.push(new LoopNote(node.right, false));
            }
            deque.push(new LoopNote(node, true));
            if (node.val >= p.val + 1 && node.left != null) {
                deque.push(new LoopNote(node.left, false));
            }
        }
        return null;
    }

    public static class LoopNote {
        public TreeNode node;
        public boolean readed;

        public LoopNote(TreeNode TreeNode, Boolean haveRead) {
            readed = haveRead;
            node = TreeNode;
        }
    }

}
