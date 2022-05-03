package lab.leetcode;

/**
 * @author Jason/XiaoJie
 * @date 2021/2/8
 */
public class M978 {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }

    public static int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 1;
        int current = 1;
        int lastCompareResult = 0;
        for (int i = 1; i < arr.length; i++) {
            int compareResult = Integer.compare(arr[i], arr[i - 1]);
            if (compareResult == 0) {
                lastCompareResult = 0;
                max = Math.max(max, current);
                current = 1;
            } else {
                if (compareResult + lastCompareResult == 0 || i == 1) {
                    current++;
                } else {
                    max = Math.max(max, current);
                    current = 1;
                }
                lastCompareResult = compareResult;
            }
        }
        max = Math.max(max, current);
        return max;
    }
}
