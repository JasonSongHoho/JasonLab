package lab.leetcode;

import lab.leetcode.common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author jasonsong
 * 2020/6/25
 */


public class E108 {

    static int[] cnums;

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        cnums = nums;
        return createBST(0, nums.length - 1);
    }

    public static TreeNode createBST(int l, int h) {
        if (l > h) {
            return null;
        }
        int m = l + (h - l) / 2;
        TreeNode parent = new TreeNode(cnums[m]);
        parent.left = createBST(l, m - 1);
        parent.right = createBST(m + 1, h);
        return parent;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        int[] nums1 = {-10, -7, -3, 0, 5, 9, 13, 17, 21};
        TreeNode sortedBST = sortedArrayToBST(nums);
        TreeNode sortedBST1 = sortedArrayToBST(nums1);
        System.out.println(sortedBST);
        System.out.println(sortedBST1);
    }

}
