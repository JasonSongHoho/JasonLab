package lab.leetcode;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 *
 * @author Jason/XiaoJie
 * @date 2022/5/18
 */
public class E62 {
    public int uniquePaths(int m, int n) {
        int[][] state = new int[m][n];
        for (int i = 0; i < m; i++) {
            state[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            state[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                state[i][j] = state[i - 1][j] + state[i][j - 1];
            }
        }
        return state[m - 1][n - 1];
    }

}
