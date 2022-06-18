package lab.leetcode;

import lab.leetcode.common.ListNode;

/**
 * https://leetcode.cn/problems/sum-lists-lcci/
 * <p>
 * 面试题 02.05. 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @author Jason/XiaoJie
 * @date 2022/6/18
 */
public class MSJD_M_0205 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel, head1 = l1, head2 = l2;
        int temp, carry = 0;
        while (head1 != null && head2 != null) {
            temp = carry + head1.val + head2.val;
            carry = temp / 10;
            head.next = new ListNode(temp % 10);
            head = head.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            temp = carry + head1.val;
            carry = temp / 10;
            head.next = new ListNode(temp % 10);
            head = head.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp = carry + head2.val;
            carry = temp / 10;
            head.next = new ListNode(temp % 10);
            head = head.next;
            head2 = head2.next;
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }
        return sentinel.next;
    }
}
