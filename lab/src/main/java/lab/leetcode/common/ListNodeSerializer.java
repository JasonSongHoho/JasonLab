package lab.leetcode.common;

/**
 * @author jasonsong
 * 2020/6/26
 */


public class ListNodeSerializer {

    /**
     * 链表反序列化
     *
     * @param data "[1, 2, 3, 3, 2, 1]"
     * @return
     */
    public static ListNode deserialize(String data) {
        String[] split = data.substring(1, data.length() - 1).replace(" ", "").split(",");
        if (split[0].isEmpty()){
            return null;
        }
        ListNode listNode = new ListNode(Integer.valueOf(split[0]));
        ListNode head = listNode;
        for (int i = 1; i < split.length; i++) {
            head.next = new ListNode(Integer.valueOf(split[i]));
            head = head.next;
        }
        return listNode;
    }

    private static ListNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new ListNode(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        String data = "[1,2,3,3,2,1]";
        ListNode deserialize = ListNodeSerializer.deserialize(data);
        System.out.println(deserialize);
        String serialize = ListNodeSerializer.serialize(deserialize);
        System.out.println(serialize);
    }

    public static String serialize(ListNode listNode) {
        if (listNode == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(listNode.val).append(",");
        ListNode next = listNode;
        while ((next = next.next) != null) {
            stringBuilder.append(next.val).append(",");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1) + "]";
    }
}
