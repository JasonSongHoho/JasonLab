package lab.leetcode.bytedance;

/**
 * @author jasonsong
 * 2020/9/21
 */


public class M547 {
    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 1, 0},
                new int[]{0, 0, 1},
        }));
    }

    public static int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
}
