package lab.leetcode.bytedance;

import lab.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author jasonsong
 * 2020/9/20
 */


public class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            LinkedList<TreeNode> temp = new LinkedList<>();
            LinkedList<Integer> item = new LinkedList<>();
            TreeNode node;
            while(!queue.isEmpty()){
                node = queue.poll();
                if(flag){
                    item.addFirst(node.val);
                }else{
                    item.add(node.val);
                }
                if(node.left != null){
                    temp.offer(node.left);
                }
                if(node.right != null){
                    temp.offer(node.right);
                }
            }
            flag = ! flag;
            queue = temp;
            result.add(item);
        }
        return result;
    }

}
