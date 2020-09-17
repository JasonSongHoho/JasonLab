package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 685. 冗余连接 II
 * 在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的有向图如下:
 * 1
 * / \
 * v   v
 * 2-->3
 * 示例 2:
 * <p>
 * 输入: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * 输出: [4,1]
 * 解释: 给定的有向图如下:
 * 5 <- 1 -> 2
 * ^    |
 * |    v
 * 4 <- 3
 * 注意:
 * <p>
 * 二维数组大小的在3到1000范围内。
 * 二维数组中的每个整数在1到N之间，其中 N 是二维数组的大小。
 * <p>
 * <p>
 * todo need redo
 *
 * @author jasonsong
 * 2020/9/17
 */


public class H685 {
    int[] parents;

    public static void main(String[] args) {
        H685 h685 = new H685();
//        System.out.println(Arrays.toString(h685.findRedundantDirectedConnection(new int[][]{
//                new int[]{1, 2},
//                new int[]{2, 3},
//                new int[]{3, 1}
//        })));
        System.out.println(Arrays.toString(h685.findRedundantDirectedConnection(new int[][]{
                new int[]{2, 1},
                new int[]{3, 1},
                new int[]{4, 2},
                new int[]{1, 4}
        })));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        init(edges.length + 1);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (!union(x, y)) {
                return new int[]{x, y};
            }
        }
        return new int[]{0, 0};
    }

    private boolean union(int x, int y) {
        int parentX = find(x), parentY = find(y);
        if (parentX == parentY) {
            return false;
        }
        parents[parentX] = parentY;
        return true;
    }

    private int find(int n) {
        if (parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }


    private void init(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }


}