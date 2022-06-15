package lab.leetcode;

import java.util.Arrays;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/14
 */
public class M498 {
    public static void main(String[] args) {
        int[] diagonalOrder = findDiagonalOrder(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}
                });
        System.out.println(Arrays.toString(diagonalOrder));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int index = 0;
        boolean toRight = true;
        ans[index] = mat[0][0];
        index++;
        for (int i = 0, j = 0; i < m && j < n && index < m * n; ) {
            if (toRight) {
                if (i - 1 >= 0 && j + 1 < n) {
                    i--;
                    j++;
                } else {
                    if (j + 1 < n) {
                        j++;
                    } else if (i + 1 < m) {
                        i++;
                    } else {
                        break;
                    }
                    toRight = false;
                }
            } else {
                if (i + 1 < m && j - 1 >= 0) {
                    i++;
                    j--;
                } else {
                    if (i + 1 < m) {
                        i++;
                    } else if (j + 1 < n) {
                        j++;
                    } else {
                        break;
                    }
                    toRight = true;
                }
            }
            ans[index] = mat[i][j];
            index++;
            double random = Math.random();
        }
        return ans;
    }

}
