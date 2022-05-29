package lab.leetcode;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class H85 {

    static int[][] dpTop;
    static int[][] dpLeft;

    public static int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        dpTop = new int[rows + 1][cols + 1];
        dpLeft = new int[rows + 1][cols + 1];
        char val;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                val = matrix[i - 1][j - 1];
                if (val == '1') {
                    dpTop[i][j] = 1 + dpTop[i - 1][j];
                    dpLeft[i][j] = 1 + dpLeft[i][j - 1];
                    ans = Math.max(ans, getMaxArea(i, i - (dpTop[i][j] - 1), j));
                }
            }
        }
        return ans;
    }

    private static int getMaxArea(int startRow, int endRow, int colNum) {
        int ans = 0;
        int minLen = dpLeft[startRow][colNum];
        for (int i = startRow; i >= endRow; i--) {
            minLen = Math.min(minLen, dpLeft[i][colNum]);
            ans = Math.max(ans, (startRow - i + 1) * minLen);
        }
        return ans;
    }

    public static void main(String[] args) {
    }
}
