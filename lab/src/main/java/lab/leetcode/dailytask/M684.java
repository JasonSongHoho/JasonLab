package lab.leetcode.dailytask;

/**
 * @author jasonsong
 * 2020/9/17
 */


public class M684 {
    private int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        init(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!union(x, y)) {
                return new int[]{x, y};
            }
        }
        return new int[]{0, 0};
    }

    private void init(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    private boolean union(int x, int y) {
        int parentX = find(x), parentY = find(y);
        if (parentX == parentY) {
            return false;
        }
        parents[parentX] = parentY;
        return true;
    }

    private int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }


}
