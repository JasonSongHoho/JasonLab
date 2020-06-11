package lab.leetcode.dailytask;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jasonsong
 * 2020/6/5
 */

@Slf4j
public class E24 {

    public static void main(String[] args) {
        int[][] matrix0 = {{3}, {2}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix2 = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}};
        int[] ints = spiralOrder(matrix0);
        System.out.println(JSON.toJSONString(ints));

    }

    public static int[] spiralOrder(int[][] matrix) {
        int length1 = matrix.length;
        if (length1 == 0) {
            return new int[0];
        }
        int length2 = matrix[0].length;
        int cLength1 = 0;
        int cLength2 = 0;

        int m = 0;
        int n = 0;
        int index = 0;
        int[] result = new int[length1 * length2];
        int direct = 0;
        while (true) {
            result[index] = matrix[m][n];
            index++;
            if (index >= result.length) {
                break;
            }
            switch (direct) {
                case 0:
                    if (n + 1 >= (length2 - cLength2)) {
                        direct = 1;
                        m++;
                    } else {
                        n++;
                        if (n + 1 >= (length2 - cLength2)) {
                            direct = 1;
                        }
                    }
                    break;
                case 1:
                    if (m + 1 >= (length1 - cLength1)) {
                        direct = 2;
                    } else {
                        m++;
                        if (m + 1 >= (length1 - cLength1)) {
                            direct = 2;
                        }
                    }
                    break;
                case 2:
                    n--;
                    if (n - 1 < cLength2) {
                        direct = 3;
                        cLength2++;
                    }
                    break;
                case 3:
                default:
                    m--;
                    if (m - 1 < cLength1) {
                        cLength1++;
                        m++;
                        n++;
                        direct = 0;
                    }
                    break;
            }
        }

        return result;
    }
}
