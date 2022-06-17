package lab.real.t2022;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/17
 */
public class Shopee2 {
    // Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

// 1234 + 56 = 1290
// 1->2->3->4 + 5->6 = 1->2->9->0

// 正整数
// 只使用单向链表

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }

    public static Node addTwoNode(Node nodeA, Node nodeB) {
        if (nodeA == null) {
            return nodeB;
        }
        if (nodeB == null) {
            return nodeA;
        }
        Node revNodeA = reverse(nodeA);
        Node revNodeB = reverse(nodeB);
        int valA, valB, tmp, last = 0;
        Node ans = new Node();
        Node head = new Node();
        ans.next = head;
        while (true) {
            valA = revNodeA != null ? revNodeA.val : 0;
            valB = revNodeB != null ? revNodeB.val : 0;
            tmp = last + valA + valB;
            last = tmp / 10;
            tmp = tmp % 10;
            head.val = tmp;
            revNodeA = revNodeA != null ? revNodeA.next : revNodeA;
            revNodeB = revNodeB != null ? revNodeB.next : revNodeB;
            if (revNodeA == null && revNodeB == null) {
                break;
            }
            head.next = new Node();
            head = head.next;
        }
        if (last > 0) {
            head.next = new Node(last);
        }
        return reverse(ans.next);

    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node last = node, next, cur = node.next;
        while (true) {
            next = cur.next;
            cur.next = last;
            if (next == null) {
                return cur;
            }
            last = cur;
            cur = next;
        }
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
        }
    }
}


// short url service
//
//
//    id(bigint(18)) code(int(11)) status(tinyint(4)) expire_time(timestamp) original_url(varchar(255)) department(varchar(32)) applyUser(varchar(64)) app(varchar(64)) createTime(timestamp)  update_time(timestamp)
//
//    primary key ('id')
//    key('code','status')
//    key('create_time')










