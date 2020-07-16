package lab.leetcode.dailytask;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. 判断二分图
 * 给定一个无向图graph，当这个图为二分图时返回true。
 * <p>
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 * <p>
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。
 * 每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 * <p>
 * <p>
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * 注意:
 * <p>
 * graph 的长度范围为 [1, 100]。
 * graph[i] 中的元素的范围为 [0, graph.length - 1]。
 * graph[i] 不会包含 i 或者有重复的值。
 * 图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 * @author jasonsong
 * 2020/7/17
 */


public class M785 {
    private static int[][] globalGraph;
    private static int[] visited;

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1}, {0, 3}, {3}, {1, 2}}));


    }


    /**
     * DFS
     *
     * @param graph
     * @return
     */
    public static boolean isBipartite(int[][] graph) {
        int length = graph.length;
        globalGraph = graph;
        visited = new int[graph.length];
        for (int i = 0; i < length; i++) {
            if (visited[i] == 0 && !dfs(i, 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int index, int color) {
        int[] graphItem = globalGraph[index];
        for (int point : graphItem) {
            if (visited[point] == color) {
                return false;
            }
            if (visited[point] == 0) {
                visited[point] = -color;
                if (!dfs(point, -color)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * BFS
     *
     * @param graph
     * @return
     */
    public static boolean isBipartite1(int[][] graph) {
        int length = graph.length;
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                Integer j = queue.poll();
                for (Integer point : graph[j]) {
                    if (visited[point] == visited[j]) {
                        return false;
                    }
                    if (visited[point] == 0) {
                        visited[point] = -visited[j];
                        queue.offer(point);
                    }
                }
            }

        }
        return true;
    }


//    private static boolean dfs(int[][] graph, int[] visited, int color) {
//        for (int[] graphItem:graph) {
//
//            int head = graphItem[0];
//            if (visited[head] == color) {
//                return false;
//            }
//            if (visited[head] == 0) {
//                visited[head] = -color;
//                dfs(graph[head], visited, -color);
//            }
//        }
//
//
//        return true;
//    }

}
