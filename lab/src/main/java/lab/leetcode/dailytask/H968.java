package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

/**
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 *
 *
 *
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 * 提示：
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 *
 * @author jasonsong
 * 2020/9/22
 */


public class H968 {
    int count = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 1) {
            count++;
        }
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }
        int result;
        int resultLeft = dfs(node.left);
        int resultRight = dfs(node.right);
        if (resultLeft == 1 || resultRight == 1) {
            result = 3;
            count++;
        } else if (resultLeft == 3 || resultRight == 3) {
            result = 2;
        } else {
            result = 1;
        }
        return result;
    }
}
