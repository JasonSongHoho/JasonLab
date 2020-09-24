package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 *
 * @author jasonsong
 * 2020/9/24
 */


public class E501 {
    int maxCount, current, currentCount;
    List<Integer> valList;
    boolean haveInit;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        haveInit = false;
        maxCount = 0;
        valList = new ArrayList<>();
        dfs(root);
        if (currentCount >= maxCount) {
            if (currentCount > maxCount) {
                valList = new ArrayList<>();
            }
            valList.add(current);
        }
        int[] result = new int[valList.size()];
        for (int i = 0; i < valList.size(); i++) {
            result[i] = valList.get(i);
        }
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        } else {
            dfs(node.left);
            if (!haveInit) {
                current = node.val;
                currentCount = 1;
                haveInit = true;
            } else if (current == node.val) {
                currentCount++;
            } else {
                if (currentCount >= maxCount) {
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        valList = new ArrayList<>();
                    }
                    valList.add(current);
                }
                current = node.val;
                currentCount = 1;
            }
            dfs(node.right);
        }
    }
}
