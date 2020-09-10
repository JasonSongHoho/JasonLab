package lab.leetcode.bytedance;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

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
 * 2020/9/11
 */


public class E21 {
    public static void main(String[] args) {
        System.out.println(ListNodeSerializer.serialize(mergeTwoLists(ListNodeSerializer.deserialize("[1, 2, 4]"),
                ListNodeSerializer.deserialize("[1, 3, 4]"))));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mList = new ListNode(0, null);
        ListNode head = mList;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mList.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                mList.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            mList = mList.next;
        }
        if (l1 != null) {
            mList.next = l1;
        }
        if (l2 != null) {
            mList.next = l2;
        }
        return head.next;
    }
}
