package lab.leetcode.dailytask;

import java.util.HashMap;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 *
 * @author jasonsong
 * 2020/6/15
 */


public class E14 {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String[] strs1={"dog","racecar","car"};
        String[] strs2={"aa","a"};

        System.out.println(longestCommonPrefix(strs2));
    }

    /**
     * 纵向比较
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < commonPrefix.length()) {
                commonPrefix = commonPrefix.substring(0, strs[i].length());
            }
            if (!strs[i].startsWith(commonPrefix)) {
                //todo 改为二分查找
                commonPrefix = searchCommonPrefix(commonPrefix, strs[i]);
            }
        }

        return commonPrefix;
    }

    public static String searchCommonPrefix(String commonPrefix, String item) {
        int length = commonPrefix.length();
        StringBuilder tempCommonPrefix= new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = commonPrefix.charAt(i);
            boolean equal = c == item.charAt(i);
            if (equal) {
                tempCommonPrefix.append(c);
            }else {
                break;
            }
        }
        return tempCommonPrefix.toString();
    }


    public static String binarySearchCommonPrefix(String commonPrefix, String item) {
        int length = commonPrefix.length();
        int l = 0;
        int h = length - 1;
        int index = (h - l) / 2;
        HashMap<Integer, Boolean> map = new HashMap<>();
        while (index >=l && index <= h){
            boolean equal = commonPrefix.charAt(index) == item.charAt(index);
            if (equal) {
//                commonPrefix.charAt(index - 1) == item.charAt(index);
            }
            index = (h - l) / 2;
        }
        return "";
    }

}
