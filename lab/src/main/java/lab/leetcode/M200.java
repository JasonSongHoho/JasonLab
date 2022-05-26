package lab.leetcode;

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @author Jason/XiaoJie
 * @date 2022/5/26
 */
public class M200 {
    class Solution {
        int m = 0;
        int n = 0;
        public int numIslands(char[][] grid) {
            int total = 0;
            m = grid.length;
            n = grid[0].length;
            for(int i = 0; i < m; i++ ){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        total++;
                        dfs(grid, i, j);
                    }
                }
            }
            return total;
        }

        private void dfs(char[][] grid, int i, int j){
            if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0'){
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
        }
    }
}
