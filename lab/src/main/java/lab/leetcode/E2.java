package lab.leetcode;

import lab.leetcode.common.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jasonsong
 * 2018/12/23
 */


public class E2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(E2.class);

    public static void main(String[] args) {
        E2 e2 = new E2();
        ListNode l1 = new ListNode(2);
        ListNode head = l1;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;
        head.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        head = l2;
        head.next = new ListNode(6);
        head = head.next;
        head.next = new ListNode(4);
        head = head.next;
        head.next = new ListNode(1);
        LOGGER.info("result:{}", e2.addTwoNumbers(l1, l2));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int total;
        int tmp = 0;
        while (true) {
            total = (tmp + l1.val + l2.val) % 10;
            tmp = (tmp + l1.val + l2.val) / 10;
            head.next = new ListNode(total);
            head = head.next;
            if (l1.next == null && l2.next == null && tmp == 0) {
                break;
            }
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = new ListNode(0);
            }
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = new ListNode(0);
            }

        }
        return result.next;
    }

}
