package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 *
 * @author jasonsong
 * 2020/7/21
 */


public class M95 {
    public static void main(String[] args) {
        System.out.println("\ngenerateTrees 0");
        for (TreeNode treeNode : generateTrees(0)) {
            System.out.println(TreeSerialize.serialize(treeNode));
        }
        System.out.println("\ngenerateTrees 1");
        for (TreeNode treeNode : generateTrees(1)) {
            System.out.println(TreeSerialize.serialize(treeNode));
        }

        System.out.println("\ngenerateTrees 2");
        for (TreeNode treeNode : generateTrees(2)) {
            System.out.println(TreeSerialize.serialize(treeNode));
        }

        System.out.println("\ngenerateTrees 3");
        for (TreeNode treeNode : generateTrees(3)) {
            System.out.println(TreeSerialize.serialize(treeNode));
        }
//
//        System.out.println("\ngenerateTrees 8");
//        for (TreeNode treeNode : generateTrees(8)) {
//            System.out.println(TreeSerialize.serialize(treeNode));
//        }
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    public static List<TreeNode> helper(int left, int right) {
        List<TreeNode> result = new LinkedList<>();
        if (left == right) {
            result.add(new TreeNode(left));
            return result;
        } else if (left > right) {
            result.add(null);
            return result;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftResults = helper(left, i - 1);
            List<TreeNode> rightResults = helper(i + 1, right);
            for (TreeNode leftNode : leftResults) {
                for (TreeNode rightNode : rightResults) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }


}
