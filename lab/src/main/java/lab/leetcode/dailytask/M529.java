package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 *
 * 示例 1：
 *
 * 输入:
 *
 * [
 * ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']
 *  ]
 *
 * Click : [3,0]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 * 示例 2：
 *
 * 输入:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * 输出:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * 解释:
 *
 *
 *
 * 注意：
 *
 * 输入矩阵的宽和高的范围为 [1,50]。
 * 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。
 * 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 *
 *
 * @author jasonsong
 * 2020/8/20
 */


public class M529 {

    public static void main(String[] args) {

        M529 m529 = new M529();
        m529.updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        }, new int[]{3, 0});
        System.out.println();
        m529.updateBoard(new char[][]{
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'X', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        }, new int[]{1,2});
        System.out.println();
        m529.updateBoard(new char[][]{
                {'B','B','B','B','1','M','M','E'},
                {'B','B','B','B','1','4','M','E'},
                {'B','B','B','B','B','3','M','E'},
                {'B','B','B','B','B','2','M','E'},
                {'1','2','2','1','B','1','1','1'},
                {'E','M','M','1','B','B','B','B'},
                {'E','E','E','2','2','2','2','1'},
                {'E','E','E','E','M','M','E','M'}
        }, new int[]{7,2});


    }





    int m;
    int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        if (click[0] < 0 || click[0] >= m || click[1] < 0 || click[1] >= n) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        char[][] signedBoard = signBoard(board);
        dfs(board, signedBoard, click[0], click[1]);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
//        [["B","B","B","B","1","M","M","E"],
//        ["B","B","B","B","1","4","M","E"],
//        ["B","B","B","B","B","3","M","E"],
//        ["B","B","B","B","B","2","M","E"],
//        ["1","2","2","1","B","1","1","1"],
//        ["E","M","M","1","B","B","B","B"],
//        ["1","2","2","2","2","2","2","1"],
//        ["B","B","B","1","M","M","E","M"]]
        return board;
    }

    private void dfs(char[][] board, char[][] signedBoard, int i, int j) {
        if (signedBoard[i][j] == 'E') {
            board[i][j] = 'B';
            signedBoard[i][j] = 'B';
            for (int k = i - 1; k <= i + 1; k++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    if (k >= 0 && k < m && l >= 0 && l < n && (k != i || l != j)) {
                        dfs(board, signedBoard, k, l);
                    }
                }
            }
        } else if (signedBoard[i][j] >= '1' && signedBoard[i][j] <= '8') {
            board[i][j] = signedBoard[i][j];
        }
    }

    private char[][] signBoard(char[][] board) {
        char[][] signedBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < '1' || board[i][j] > '8') {
                    signedBoard[i][j] = board[i][j];
                } else {
                    signedBoard[i][j] = 'E';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (signedBoard[i][j] == 'M') {
                    signCell(signedBoard, i, j);
                }
            }
        }
        return signedBoard;
    }

    private void signCell(char[][] board, int i, int j) {
        if (j - 1 >= 0) {
            if (i - 1 >= 0) {
                increment(board, i - 1, j - 1);
            }
            increment(board, i, j - 1);
            if (i + 1 < m) {
                increment(board, i + 1, j - 1);
            }
        }
        if (i - 1 >= 0) {
            increment(board, i - 1, j);
        }
        if (i + 1 < m) {
            increment(board, i + 1, j);
        }
        if (j + 1 < n) {
            if (i - 1 >= 0) {
                increment(board, i - 1, j + 1);
            }
            increment(board, i, j + 1);
            if (i + 1 < m) {
                increment(board, i + 1, j + 1);
            }
        }
    }

    private void increment(char[][] board, int i, int j) {
        char c = board[i][j];
        if (c == 'E') {
            board[i][j] = '1';
        } else if (c != 'M') {
            board[i][j] += 1;
        }
    }


    /**
     *
     作者：sweetiee
     链接：https://leetcode-cn.com/problems/minesweeper/solution/cong-qi-dian-kai-shi-dfs-bfs-bian-li-yi-bian-ji-ke/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 定义 8 个方向
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        public char[][] updateBoard(char[][] board, int[] click) {
            int x = click[0], y = click[1];
            // 1. 若起点是雷，游戏结束，直接修改 board 并返回。
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else { // 2. 若起点是空地，则从起点开始向 8 邻域的空地进行深度优先搜索。
                dfs(board, x, y);
            }
            return board;
        }

        private void dfs(char[][] board, int i, int j) {
            // 递归终止条件：判断空地 (i, j) 周围是否有雷，若有，则将该位置修改为雷数，终止该路径的搜索。
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    continue;
                }
                if (board[x][y] == 'M') {
                    cnt++;
                }
            }
            if (cnt > 0) {
                board[i][j] =  (char)(cnt + '0');
                return;
            }

            // 若空地 (i, j) 周围没有雷，则将该位置修改为 ‘B’，向 8 邻域的空地继续搜索。
            board[i][j] = 'B';
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                dfs(board, x, y);
            }
        }
    }


}
