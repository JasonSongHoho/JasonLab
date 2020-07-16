package lab.tonghuashun;

import java.util.Arrays;

/**
 * 输入两个有序数组，返回一个有序数组
 *
 * @author jasonsong
 * 2020/7/15
 */


public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 5, 7, 9, 12}, new int[]{1, 3, 6, 8, 10})));
    }

    public static int[] merge(int[] arraysM, int[] arraysN) {
        int lengthM = arraysM.length;
        int lengthN = arraysN.length;
        int[] result = new int[lengthM + lengthN];
        int valueM;
        int valueN;
        int index = 0;
        int i;
        int j;
        for (i = 0, j = 0; i < lengthM && j < lengthN; ) {
            valueM = arraysM[i];
            valueN = arraysN[j];
            if (valueM > valueN) {
                result[index++] = valueN;
                j++;
            } else {
                result[index++] = valueM;
                i++;
            }
        }
        while (i < lengthM) {
            result[index++] = arraysM[i++];
        }
        while (j < lengthN) {
            result[index++] = arraysN[j++];
        }
        return result;
    }
}
