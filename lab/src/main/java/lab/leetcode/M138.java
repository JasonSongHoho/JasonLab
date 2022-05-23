package lab.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/22
 */
public class M138 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node copyNode;
        while (cur != null) {
            copyNode = map.get(cur);
            copyNode.next = map.get(cur.next);
            copyNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
