package lab.leetcode.dailytask;

import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * @author jasonsong
 * 2020/9/8
 */


public class E589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
        } else {
            return;
        }
        List<Node> childrens = node.children;
        if (childrens != null) {
            for (Node children : childrens) {
                dfs(children, result);
            }
        }
    }

    /**
     * N 叉树
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}




