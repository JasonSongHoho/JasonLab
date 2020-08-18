package lab.leetcode.dailytask;

import lab.leetcode.common.ListNode;
import lab.leetcode.common.ListNodeSerializer;
import lab.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasonsong
 * 2020/8/18
 */


public class M109 {
    public static void main(String[] args) {
        System.out.println(sortedListToBST(ListNodeSerializer.deserialize("[-10,-3,0,5,9]")));
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> values = new ArrayList<>();
        do {
            values.add(head.val);
        } while ((head = head.next) != null);
        Integer[] valueArr = values.toArray(new Integer[0]);
        return createTree(valueArr, 0, values.size() - 1);
    }

    private static TreeNode createTree(Integer[] valueArr, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(valueArr[mid]);
        treeNode.left = createTree(valueArr, left, mid - 1);
        treeNode.right = createTree(valueArr, mid + 1, right);
        return treeNode;
    }

    /**
     * 快慢指针
     * <p>
     * <p>
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 快慢指针找中心节点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        // 以升序链表的中间元素作为根节点 root，递归的构建 root 的左子树与右子树。
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

}
