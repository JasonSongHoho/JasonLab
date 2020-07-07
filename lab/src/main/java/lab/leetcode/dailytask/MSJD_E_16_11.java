package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 *
 * @author jasonsong
 * 2020/7/8
 */


public class MSJD_E_16_11 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(1, 2, 10)));
    }

    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter==longer){
            int[] result = new int[1];
            result[0]=shorter*k;
            return result;
        }
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = shorter * (k - i) + longer * (i);
        }
        return result;
    }

}
