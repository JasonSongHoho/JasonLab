package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/9/6
 */


public class E107 {
    public static void main(String[] args) {
        System.out.println(levelOrderBottom(TreeSerialize.deserialize("[3,9,20,null,null,15,7]")));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> item = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> tmpQueue = new LinkedList<>();
        queue.add(root);
        while (true) {
            TreeNode node = queue.poll();
            if (node == null) {
                queue = new LinkedList<>(tmpQueue);
                tmpQueue.clear();
                result.addFirst(new LinkedList<>(item));
                item.clear();
                if (queue.isEmpty()) {
                    break;
                } else {
                    node = queue.pop();
                }
            }
            item.add(node.val);
            if (node.left != null) {
                tmpQueue.add(node.left);
            }
            if (node.right != null) {
                tmpQueue.add(node.right);
            }
        }
        return result;
    }
}
