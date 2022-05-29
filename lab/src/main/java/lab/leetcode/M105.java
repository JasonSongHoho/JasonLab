package lab.leetcode;

import lab.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class M105 {
    public static void main(String[] args) {
        buildTree(new int[]{3, 9, 8, 11, 20, 15, 7}, new int[]{8, 9, 11, 3, 15, 20, 7});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        TreeNode root = new TreeNode(preorder[0]);
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            if (inList.get(i).equals(preList.get(0))) {
                if (i > 0) {
                    buildTree(preList.subList(1, i + 1), inList.subList(0, i), root, true);
                }
                if (i < n - 1) {
                    buildTree(preList.subList(i + 1, n), inList.subList(i + 1, n), root, false);
                }
            }
        }
        return root;
    }


    public static void buildTree(List<Integer> preList, List<Integer> inList, TreeNode parent, boolean isLeft) {
        if (preList.size() == 0) {
            return;
        }
        TreeNode node = new TreeNode(preList.get(0));
        if (isLeft) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        int n = inList.size();
        for (int i = 0; i < n; i++) {
            if (inList.get(i).equals(preList.get(0))) {
                if (i > 0) {
                    buildTree(preList.subList(1, i + 1), inList.subList(0, i), node, true);
                }
                if (i < n - 1) {
                    buildTree(preList.subList(i + 1, n), inList.subList(i + 1, n), node, false);
                }
            }
        }
    }
}
