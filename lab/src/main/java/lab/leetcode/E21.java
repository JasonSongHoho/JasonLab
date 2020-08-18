package lab.leetcode;

import lab.leetcode.common.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author jasonsong
 * 2020/8/18
 */


public class E21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode mergeList = new ListNode();
        ListNode head = mergeList;
        ListNode pre = new ListNode();
        ListNode next;
        int val;
        while (true) {
            if (l1 == null) {
                if (l2 == null) {
                    break;
                } else {
                    val = l2.val;
                    l2 = l2.next;
                }
            } else {
                if (l2 == null || l1.val < l2.val) {
                    val = l1.val;
                    l1 = l1.next;
                } else {
                    val = l2.val;
                    l2 = l2.next;
                }
            }
            mergeList.val = val;
            next = new ListNode();
            pre = mergeList;
            mergeList.next = next;
            mergeList = next;
        }
        pre.next = null;
        return head;
    }
}
