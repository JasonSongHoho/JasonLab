package lab.leetcode.dailytask;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jasonsong
 * 2020/8/30
 */


public class M670 {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2745));
        System.out.println(maximumSwap(9973));
    }

    public static int maximumSwap(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        int shift = num;
        int value;
        while (shift > 0) {
            value = shift % 10;
            shift = shift / 10;
            list.add(value);
        }
        int[] values = new int[list.size()];
        int index = 0;
        for (int item : list) {
            values[index++] = item;
        }
        Arrays.sort(values);
        int temp = -1;
        int target = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (values[i] > list.get(i)) {
                target = values[i];
                temp = list.get(i);
                list.set(i, values[i]);
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (target == list.get(i)) {
                list.set(i, temp);
                target = -1;
            }
            stringBuilder.append(list.get(i));
        }

        return Integer.parseInt(stringBuilder.reverse().toString());
    }


    public int maximumSwap1(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

}
