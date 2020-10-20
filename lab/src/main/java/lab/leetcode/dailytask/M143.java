package lab.leetcode.dailytask;

import lab.leetcode.common.ListNode;

import java.util.Stack;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author jasonsong
 * 2020/10/21
 */


public class M143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
            length++;
        }
        ListNode popNode;
        for (int i = 0; i < length / 2; i++) {
            popNode = stack.pop();
            popNode.next = head.next;
            head.next = popNode;
            head = popNode.next;
        }
        head.next = null;
    }
}
