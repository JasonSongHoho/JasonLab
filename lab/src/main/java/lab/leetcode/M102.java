package lab.leetcode;

import com.alibaba.fastjson.JSON;
import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author jasonsong
 * 2020/6/18
 */


public class M102 {
    public static void main(String[] args) {
        String data = "[3,9,20,21,6,15,7,30,31,null,33,34,35,36,null]";
        TreeNode deserialize = TreeSerialize.deserialize(data);
        List<List<Integer>> lists = levelOrder(deserialize);
        System.out.println(JSON.toJSONString(lists));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int itemSize = queue.size();
            List<Integer> item = new ArrayList<>();
            while (--itemSize >= 0) {
                TreeNode treeNode = queue.pop();
                item.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(item);
        }
        return result;
    }
}
