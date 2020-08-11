package lab.leetcode.dailytask;

/**
 * @author jasonsong
 * 2020/8/11
 */


public class M130 {
    public static void main(String[] args) {
        char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(chars);
    }

    public static void solve(char[][] board) {
        int m = board.length;
        if (m <= 1) {
            return;
        }
        int n = board[0].length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    char c = board[i][j];
                    if (c == 'O') {
                        dfs(board, i, j, m, n);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '1') {
                    board[i][j] = 'O';
                } else if (c == 'O') {
                    board[i][j] = 'X';
                }
//                System.out.print(board[i][j]);
            }
//            System.out.println();
        }
    }

    public static void dfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '1';
        if (checkPosition(board, i + 1, j, m, n)) {
            dfs(board, i + 1, j, m, n);
        }
        if (checkPosition(board, i - 1, j, m, n)) {
            dfs(board, i - 1, j, m, n);
        }
        if (checkPosition(board, i, j + 1, m, n)) {
            dfs(board, i, j + 1, m, n);
        }
        if (checkPosition(board, i, j - 1, m, n)) {
            dfs(board, i, j - 1, m, n);
        }
    }

    private static boolean checkPosition(char[][] board, int i, int j, int m, int n) {
        return i > 0 && i < m && j > 0 && j < n && board[i][j] == 'O';
    }
}
