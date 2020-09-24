package lab.leetcode.msjd;

/**
 * 面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 * @author jasonsong
 * 2020/9/24
 */


public class E1005 {
    public static void main(String[] args) {
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ta"));
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "at"));
        System.out.println(findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
    }

    public static int findString(String[] words, String s) {
        if (s.equals("")) {
            return binarySearch(words, 0, words.length - 1, s);
        }
        String lastStr = "";
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.equals("")) {
                lastStr = word;
            } else {
                if (lastStr.equals("")) {
                    start++;
                } else {
                    words[i] = lastStr;
                }
            }
        }
        return binarySearch(words, start, words.length - 1, s);
    }

    private static int binarySearch(String[] words, int l, int r, String target) {
        int m;
        while (l < r) {
            m = l + (r - l) / 2;
            String word = words[m];
            int compare;
            int current = m;
            while ((compare = compare(word, target)) == 2 && m < l){
                word = words[++m];
            }
            if (m == l) {
                l = current;
            }
            if (compare > 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (words[l].equals(target)) {
            return l;
        } else {
            return -1;
        }
    }

    private static int compare(String str, String target) {
        if (target.equals("") && str.equals("")) {
            return 0;
        } else if (str.equals("")) {
            return 2;
        } else {
            int i = 0;
            for (; i < target.length() && i < str.length(); i++) {
                char cT = target.charAt(i);
                char cS = str.charAt(i);
                if (cT - cS > 0) {
                    return 1;
                } else if (cT - cS < 0) {
                    return -1;
                }
            }
            if (i == str.length() && i == target.length()) {
                return 0;
            } else if (i >= str.length()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
