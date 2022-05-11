package lab.leetcode;

import lab.leetcode.common.TreeNode;
import lab.leetcode.common.TreeSerialize;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 *
 * @author Jason/XiaoJie
 * @date 2022/5/11
 */
public class M449 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.push(root);
            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                if (node != null) {
                    result.append(",").append(node.val);
                    queue.push(node.right);
                    queue.push(node.left);
                } else {
                    result.append(",").append("null");
                }
            }
            return result.substring(1);
        }

        /**
         * 深度遍历
         * @param data
         * @return
         */
        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] split = data.split(",");
            if (split.length == 0) {
                return null;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            TreeNode root = getNode(split[0]);
            queue.push(root);
            boolean isLeft = true;
            for (int i = 1; i < split.length; i++) {
                TreeNode node = getNode(split[i]);
                if (node != null) {
                    TreeNode cur = queue.pop();
                    if (isLeft) {
                        cur.left = node;
                        queue.push(cur);
                        queue.push(cur.left);
                    } else {
                        cur.right = node;
                        queue.push(cur.right);
                        isLeft = !isLeft;
                    }
                } else {
                    if (isLeft) {
                        isLeft = !isLeft;
                    } else {
                        queue.pop();
                    }
                }
            }
            return root;
        }


        public static void main(String[] args) {
            String data = "[9,25,25,null,-95,-95,null,-100,null,null,-15]";
            TreeNode treeNode = TreeSerialize.deserialize(data);
            String serializeStr = serialize(treeNode);
            System.out.println(serializeStr);
            TreeNode deserializeTreeNode = deserialize(serializeStr);
            System.out.println(TreeSerialize.serialize(deserializeTreeNode));
        }


//        /**
//         * 广度遍历
//         * @param data such as "[9,25,25,null,-95,-95,null,-100,null,null,-15]"
//         * @return
//         */
//        public TreeNode deserialize(String data) {
//            String[] nodes = data.substring(1, data.length() - 1).split(",");
//            if (nodes[0].isEmpty()) {
//                return null;
//            }
//            TreeNode root = getNode(nodes[0]);
//            Queue<TreeNode> parents = new LinkedList<>();
//            TreeNode parent = root;
//            boolean isLeft = true;
//            for (int i = 1; i < nodes.length; i++) {
//                TreeNode cur = getNode(nodes[i]);
//                if (isLeft) {
//                    parent.left = cur;
//                } else {
//                    parent.right = cur;
//                }
//                if (cur != null) {
//                    parents.add(cur);
//                }
//                isLeft = !isLeft;
//                if (isLeft) {
//                    parent = parents.poll();
//                }
//            }
//            return root;
//        }
//
        private static TreeNode getNode(String val) {
            if (val.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(val));
        }
//
//        public String serialize(TreeNode root) {
//            //tree: [v1,v2,null,...]
//            StringBuilder res = new StringBuilder("[");
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.add(root);
//            while (!queue.isEmpty()) {
//                TreeNode cur = queue.remove();
//                if (cur == null) {
//                    res.append("null,");
//                } else {
//                    res.append(cur.val).append(",");
//                    queue.add(cur.left);
//                    queue.add(cur.right);
//                }
//            }
//            res.setLength(res.length() - 1);
//            res.append("]");
//            return res.toString();
//        }
//    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

    }
}
