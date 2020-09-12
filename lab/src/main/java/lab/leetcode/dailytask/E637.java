package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jasonsong
 * 2020/9/12
 */


public class E637 {
    public static void main(String[] args) {
        System.out.println(averageOfLevels(TreeSerialize.deserialize("[3,9,20,null,null,15,7]")).toString());
    }

    public static List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        queue.offer(root);
        Double tempTotal = 0.0D;
        Integer tempSize = 0;
        while (!queue.isEmpty() || !tmpQueue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                tempTotal += node.val;
                tempSize++;
                if (node.left != null) {
                    tmpQueue.offer(node.left);
                }
                if (node.right != null) {
                    tmpQueue.offer(node.right);
                }
            } else {
                result.add(tempTotal / tempSize);
                tempTotal = 0.0D;
                tempSize = 0;
                queue = new LinkedList<>(tmpQueue);
                tmpQueue = new LinkedList<>();
            }
        }
        if (tempSize > 0) {
            result.add(tempTotal / tempSize);
        }
        return result;
    }


    public static List<Double> averageOfLevels1(TreeNode root) {
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();
        queue.offer(root);
        Double tempTotal = 0.0D;
        Integer tempSize = 0;
        while (!queue.isEmpty()) {
            TreeNode node;
            while ((node = queue.poll()) != null) {
                tempTotal += node.val;
                tempSize++;
                if (node.left != null) {
                    tmpQueue.offer(node.left);
                }
                if (node.right != null) {
                    tmpQueue.offer(node.right);
                }
            }
            result.add(tempTotal / tempSize);
            tempTotal = 0.0D;
            tempSize = 0;
            queue = new LinkedList<>(tmpQueue);
            tmpQueue = new LinkedList<>();
        }
        return result;
    }


    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node;
            Double tempTotal = 0D;
            Integer size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                tempTotal += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(tempTotal / size);
        }
        return result;
    }
}
