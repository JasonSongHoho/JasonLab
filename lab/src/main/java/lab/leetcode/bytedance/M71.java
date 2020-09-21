package lab.leetcode.bytedance;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 71. 简化路径
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 * 通过次数47,113提交次数117,564
 *
 * @author jasonsong
 * 2020/7/18
 */


public class M71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/a///b"));
        System.out.println(simplifyPath("/a///b//"));
        System.out.println(simplifyPath("/a///b//../c/."));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }

    public static String simplifyPath(String path) {
        if (path == null) {
            return null;
        }
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String folder : split) {
            if (folder.length() > 0 && !folder.equals(".")) {
                if (folder.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(folder);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            String folder = stack.pop();
            stringBuilder.insert(0, "/" + folder);
        }
        if (stringBuilder.length() == 0){
            return "/";
        }else {
            return stringBuilder.toString();
        }
    }

    public static String simplifyPath1(String path) {
        LinkedList<String> pathStack = new LinkedList<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String folderName = split[i];
            if (".".equals(folderName) || "".equals(folderName)) {
                continue;
            } else if ("..".equals(folderName)) {
                if (!pathStack.isEmpty()) {
                    pathStack.removeLast();
                }
            } else {
                pathStack.add(folderName);
            }
        }
        if (pathStack.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        while (!pathStack.isEmpty()) {
            result.append("/").append(pathStack.pop());
        }
        return result.toString();
    }
}
