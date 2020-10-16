package lab.leetcode.dailytask;

import java.util.LinkedList;

/**
 * @author jasonsong
 * 2020/10/15
 */


public class M116 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        Node node = connect(root);
        System.out.println(node);
    }

    public static Node connect(Node root) {
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int size = list.size();
            Node next = null;
            for (int i = 0; i < size; i++) {
                Node node = list.removeLast();
                node.next = next;
                if (node.right != null) {
                    list.addFirst(node.right);
                }
                if (node.left != null) {
                    list.addFirst(node.left);
                }
                next = node;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
