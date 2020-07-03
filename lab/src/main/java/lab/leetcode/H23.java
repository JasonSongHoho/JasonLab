package lab.leetcode;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author jasonsong
 * 2020/7/3
 */


public class H23 {

    public static void main(String[] args) {

//        ListNode[] lists = {
//                ListNodeSerializer.deserialize("[1, 4,5]"),
//                ListNodeSerializer.deserialize("[1, 3, 4]"),
//                ListNodeSerializer.deserialize("[2, 6]")
//        };
        ListNode[] lists1 = {
                ListNodeSerializer.deserialize("[]"),
                ListNodeSerializer.deserialize("[]")
        };
        System.out.println(ListNodeSerializer.serialize(mergeKLists(lists1)));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        while (lists.length > 1) {
            int index = 0;
            int mergedIndex = 0;
            int length = lists.length;
            ListNode[] mergelists = new ListNode[length / 2 + length % 2];
            while (index < length) {
                ListNode listNode = mergeList(lists, index);
                mergelists[mergedIndex] = listNode;
                index += 2;
                mergedIndex++;
            }
            lists = mergelists;
        }
        return lists[0];
    }

    public static ListNode mergeList(ListNode[] lists, int index) {
        if (index == lists.length - 1) {
            return lists[index];
        }
        ListNode list1 = lists[index];
        ListNode list2 = lists[index + 1];
        ListNode mergedList = new ListNode(0);
        ListNode head = mergedList;

        while (true) {
            if (list1 == null) {
                head.next = list2;
                break;
            }
            if (list2 == null) {
                head.next = list1;
                break;
            }
            int val1 = list1.val;
            int val2 = list2.val;
            ListNode listNode;
            if (val1 > val2) {
                listNode = new ListNode(val2);
                list2 = list2.next;
            } else {
                listNode = new ListNode(val1);
                list1 = list1.next;
            }
            head.next = listNode;
            head = head.next;
        }
        return mergedList.next;
    }

    //todo 递归法实现

}
