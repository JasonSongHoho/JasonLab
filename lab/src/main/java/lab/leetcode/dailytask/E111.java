package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

/**
 * @author jasonsong
 * 2020/8/21
 */


public class E111 {
    public static void main(String[] args) {
        System.out.println(minDepth(TreeSerialize.deserialize("[]")));
        System.out.println(minDepth(TreeSerialize.deserialize("[2]")));
        System.out.println(minDepth(TreeSerialize.deserialize("[1,2]")));
        System.out.println(minDepth(TreeSerialize.deserialize("[3,9,20,null,null,15,7]")));
        System.out.println(minDepth(TreeSerialize.deserialize("[1,2,3,4,null,null,5]")));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight;
        if (root.left == null) {
            leftHeight = Integer.MAX_VALUE;
        } else {
            leftHeight = minDepth(root.left);
        }
        int rightHeight;
        if (root.right == null) {
            rightHeight = Integer.MAX_VALUE;
        } else {
            rightHeight = minDepth(root.right);
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
