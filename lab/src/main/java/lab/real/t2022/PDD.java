package lab.real.t2022;

import java.util.Arrays;

/**
 * 复写零。 E1089
 * 定长数组，遇到0则复制后右移。空间复杂度 O(1)
 *
 * @author Jason/XiaoJie
 * @date 2022/6/17
 */
public class PDD {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        duplicateZeros(new int[]{1, 2, 3});
        duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
        duplicateZeros(new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }

    public static void duplicateZeros(int[] arr) {
        int cnt = 0, len = arr.length, i = 0, j = len - 1;
        for (; i < len; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
            if (i + cnt >= len - 1) {
                break;
            }
        }
        boolean justMvLast = false;
        if (i + cnt > len - 1) {
            justMvLast = true;
        }
        for (; i >= 0 && j >= 0; i--, j--) {
            if (arr[i] == 0 && justMvLast) {
                arr[j] = 0;
                justMvLast = false;
                continue;
            }
            if (arr[i] == 0) {
                arr[j] = 0;
                j--;
            }
            arr[j] = arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

}
