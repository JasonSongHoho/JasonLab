package lab.leetcode.bytedance;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author jasonsong
 * 2020/9/11
 */


public class M148 {
//    public ListNode sortList(ListNode head) {
//        // 1、递归结束条件
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // 2、找到链表中间节点并断开链表 & 递归下探
//        ListNode midNode = middleNode(head);
//        ListNode rightHead = midNode.next;
//        midNode.next = null;
//
//        ListNode left = sortList(head);
//        ListNode right = sortList(rightHead);
//
//        // 3、当前层业务操作（合并有序链表）
//        return mergeTwoLists(left, right);
//    }
//
//    //  找到链表中间节点（876. 链表的中间结点）
//    private ListNode middleNode(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next.next;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
//    }
//
//    // 合并两个有序链表（21. 合并两个有序链表）
//    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode sentry = new ListNode(-1);
//        ListNode curr = sentry;
//
//        while(l1 != null && l2 != null) {
//            if(l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//
//            curr = curr.next;
//        }
//
//        curr.next = l1 != null ? l1 : l2;
//        return sentry.next;
//    }

    public static void main(String[] args) {
        System.out.println(sortList(ListNodeSerializer.deserialize("[4,2,1,3]")));
        System.out.println(sortList(ListNodeSerializer.deserialize("[-1,5,3,4,0]")));
        System.out.println(sortList(ListNodeSerializer.deserialize("[-1,5,6,35,3,4,0]")));
    }

    public static ListNode sortList(ListNode head) {
        ListNode tmp = new ListNode(0, head);
        int length = 0;
        for (ListNode i = head; i != null; i = i.next) {
            length++;
        }

        for (int step = 1; step <= length; step *= 2) {
            ListNode tmp1 = tmp;
            for (int i = 0; i < length; i += 2 * step) {
                ListNode fNode = tmp1.next;
                ListNode sNode = tmp1.next;
                for (int j = 0; j < step && sNode != null; j++) {
                    sNode = sNode.next;
                }
                int firstPos = 0, secondPos = 0;
                while (firstPos < step && fNode != null && secondPos < step && sNode != null) {
                    if (fNode.val <= sNode.val) {
                        tmp1.next = fNode;
                        tmp1 = tmp1.next;
                        fNode = fNode.next;
                        firstPos++;
                    } else {
                        tmp1.next = sNode;
                        tmp1 = tmp1.next;
                        sNode = sNode.next;
                        secondPos++;
                    }
                }
                while (firstPos < step && fNode != null) {
                    tmp1.next = fNode;
                    tmp1 = tmp1.next;
                    fNode = fNode.next;
                    firstPos++;
                }
                while (secondPos < step && sNode != null) {
                    tmp1.next = sNode;
                    tmp1 = tmp1.next;
                    sNode = sNode.next;
                    secondPos++;
                }
                tmp1.next = sNode;
            }
        }
        System.out.println(ListNodeSerializer.serialize(tmp.next));
        return tmp.next;
    }

}
