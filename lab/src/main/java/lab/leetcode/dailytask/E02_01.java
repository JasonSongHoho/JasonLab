package lab.leetcode.dailytask;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jasonsong
 * 2020/6/26
 */


public class E02_01 {
    public static void main(String[] args) {
        System.out.println(ListNodeSerializer.serialize(
                removeDuplicateNodes(
                        ListNodeSerializer.deserialize("[1, 2, 3, 3, 2, 1]"))));
        System.out.println(ListNodeSerializer.serialize(
                removeDuplicateNodes(
                        ListNodeSerializer.deserialize("[1, 1, 1, 1, 2]"))));


    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> valSet = new HashSet<>();
        valSet.add(head.val);
        ListNode headNode = new ListNode(head.val);
        ListNode resultNode = headNode;
        ListNode tmpNode;
        while ((tmpNode = head.next) != null) {
            if (valSet.contains(tmpNode.val)) {
                if (tmpNode.next == null) {
                    break;
                }
                head.next = tmpNode.next;
            } else {
                valSet.add(tmpNode.val);
                head = head.next;
                headNode.next = new ListNode(tmpNode.val);
                headNode = headNode.next;
            }
        }

        return resultNode;
    }
}
