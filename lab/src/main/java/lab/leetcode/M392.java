package lab.leetcode;

/**
 * @author jasonsong
 * 2018/12/22
 */


public class M392 {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int sL = s.length();
        if (sL==0){
            return true;
        }
        for (int i = 0, j = 0;j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (i < sL - 1) {
                    i++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
