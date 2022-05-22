package lab.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author Jason/XiaoJie
 * @date 2022/5/22
 */
public class M56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> resultList = new ArrayList<>();
        int[] lastInterval = intervals[0];
        int[] curInterval;
        resultList.add(lastInterval);
        for (int i = 1; i < n; i++) {
            curInterval = intervals[i];
            if (lastInterval[1] >= curInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], curInterval[1]);
            } else {
                resultList.add(curInterval);
                lastInterval = curInterval;
            }
        }
        n = resultList.size();
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

}
