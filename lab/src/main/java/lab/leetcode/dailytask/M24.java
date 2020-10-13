package lab.leetcode.dailytask;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 * @author jasonsong
 * 2020/10/13
 */


public class M24 {
    public static void main(String[] args) {
        ListNode listNode = swapPairs(ListNodeSerializer.deserialize("[1,2,3,4]"));
        System.out.println(ListNodeSerializer.serialize(listNode));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode first, second, pre = dummy;
        while (head != null) {
            first = head;
            second = head.next;
            if (second == null) {
                break;
            }
            head = second.next;
            pre.next = second;
            second.next = first;
            first.next = head;
            pre = first;
        }
        return dummy.next;
    }
}
