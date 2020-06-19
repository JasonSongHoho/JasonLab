package lab.leetcode.dailytask;

import lab.leetcode.common.TreeNode;

import java.util.Arrays;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * <p>
 * TreeSerialize
 *
 * @author jasonsong
 * 2020/6/16
 */


public class H297 {

//    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(-2147483648);
//        TreeNode root110 = new TreeNode(-2147483648);
//
//        root1.left = root110;
//        TreeNode root = new TreeNode(3);
//        TreeNode node10 = new TreeNode(1);
//        TreeNode node11 = new TreeNode(5);
//        TreeNode node20 = new TreeNode(0);
//        TreeNode node21 = new TreeNode(2);
//        TreeNode node22 = new TreeNode(4);
//        TreeNode node23 = new TreeNode(6);
//        root.left = node10;
//        root.right = node11;
//        node10.left = node20;
//        node10.right = node21;
//        node11.left = node22;
//        node11.right = node23;
//
//
//        H297 codec = new H297();
//        String serialize = codec.serialize(root);
//        System.out.println(serialize);
//        TreeNode deserialize = codec.deserialize(serialize);
//        System.out.println("end");
//    }

    public static void main(String[] args) {
        String serialize = "9,25,25,null,-95,-95,null,-100,null,null,-15";
        TreeNode deserialize = deserialize(serialize);
        System.out.println("end");
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        getTreeString(root, stringBuilder);
        String string = stringBuilder.toString();
        if (!string.isEmpty()) {
            return string.substring(1);
        } else {
            return "";
        }
    }

    public void getTreeString(TreeNode node, StringBuilder serializeStr) {
        serializeStr.append(",").append(node.val);
        if (node.left != null) {
            getTreeString(node.left, serializeStr);
        } else {
            serializeStr.append(",null");
        }
        if (node.right != null) {
            getTreeString(node.right, serializeStr);
        } else {
            serializeStr.append(",null");
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        Integer length = split.length;
        String[] treeStringArr = Arrays.copyOf(split, length + 1);
        // 由于不能使用全局变量，将遍历的索引值放在数组最后
        treeStringArr[length] = "" + 0;
        return createTree(treeStringArr);
    }


    public  static TreeNode createTree(String[] treeStringArr) {
        int length = treeStringArr.length;
        String s = treeStringArr[length - 1];
        int i = Integer.parseInt(s);
        if (i == length - 1) {
            return null;
        }
        String value = treeStringArr[i];
        //维护遍历的索引
        treeStringArr[length - 1] = "" + (i + 1);
        if ("null".equals(value)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(value));
            node.left = createTree(treeStringArr);
            node.right = createTree(treeStringArr);
            return node;
        }
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));