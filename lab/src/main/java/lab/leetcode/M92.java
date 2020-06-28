package lab.leetcode;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author jasonsong
 * 2020/6/28
 */


public class M92 {
    public static void main(String[] args) {
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4, 5]"), 2, 4)));
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4]"), 2, 4)));
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4]"), 1, 3)));
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4]"), 1, 4)));
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4]"), 1, 1)));
        System.out.println(ListNodeSerializer.serialize(reverseBetween(ListNodeSerializer.deserialize("[1, 2, 3, 4]"), 2, 2)));

    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        if (head == null) {
            return head;
        }
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        head = listNode;
        ListNode beforeStartNode = head;
        ListNode startNode = head;
        ListNode last = head;
        ListNode next;
        int i = -1;
        while (true) {
            i++;
            if (i <= m) {
                if (i == m - 1) {
                    beforeStartNode = head;
                } else if (i == m) {
                    startNode = head;
                    last = head;
                }
                head = head.next;
            } else if (i == n) {
                next = head.next;
                head.next = last;
                startNode.next = next;
                beforeStartNode.next = head;
                break;
            } else {
                next = head.next;
                head.next = last;
                last = head;
                head = next;
            }
        }
        return listNode.next;
    }


}
