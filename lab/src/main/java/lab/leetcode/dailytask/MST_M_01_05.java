package lab.leetcode.dailytask;

/**
 * https://leetcode.cn/problems/one-away-lcci/
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author Jason/XiaoJie
 * @date 2022/5/13
 */
public class MST_M_01_05 {
    public boolean oneEditAway(String first, String second) {
        int lf = first.length();
        int ls = second.length();
        if(lf - ls == 1){
            return check(first, second);
        }else if (ls - lf == 1){
            return check(second, first);
        }else if (lf - ls == 0){
            return checkSameLength(first, second);
        }else {
            return false;
        }
    }

    private boolean check(String first, String second){
        for(int i = 0, j = 0; i < first.length() && j < second.length() ; i++, j++){
            char cf = first.charAt(i);
            char cs = second.charAt(j);
            if (cf != cs){
                if(i > j){
                    return false;
                }
                if(first.charAt(++i) != cs){
                    return false;
                }
            }
        }
        return true;
    }


    private boolean checkSameLength(String first, String second){
        int diffNum = 0;
        for(int i = 0, j = 0; i < first.length() && j < second.length() ; i++, j++){
            char cf = first.charAt(i);
            char cs = second.charAt(j);
            if (cf != cs){
                if(++diffNum > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
