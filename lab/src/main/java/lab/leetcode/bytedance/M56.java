package lab.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 *
 * @author jasonsong
 * 2020/9/19
 */


public class M56 {
    public int[][] merge(int[][] intervals) {
        if(intervals == null ){
            return null;
        }
        int l = intervals.length;
        if(l <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 1; i < l ; i++){
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            int[] lastInterval = intervals[i-1];
            int lastStart = lastInterval[0];
            int lastEnd = lastInterval[1];
            if(start <= lastEnd){
                interval[0] = lastStart;
                if(lastEnd > end){
                    interval[1] = lastEnd;
                }
            }
        }
        List<int[]> list = new ArrayList<>();
        int lastStart = intervals[0][0];
        for(int i = 0; i < l ; i++){
            int start = intervals[i][0];
            if(lastStart != start){
                list.add(intervals[i-1]);
                lastStart = start;
            }
        }
        list.add(intervals[l-1]);
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < list.size() ; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int[][] merge1(int[][] intervals) {
        Set<Integer> nums = new HashSet<>();
        Set<Double> medium = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = start; i < end; i++) {
                nums.add(i);
                medium.add((double) i + 0.5);
            }
            nums.add(end);

        }
        List<int[]> ans = new ArrayList<>();
        for (Integer index : nums) {
            if (!visited.contains(index)) {
                int start = index;
                while (nums.contains(index)) {
                    visited.add(index);
                    if (!medium.contains((double) index + 0.5)) {
                        break;
                    }
                    index++;
                }
                int end = index;
                ans.add(new int[]{start, end});
            }
        }
        int[][] ansArr = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(i);
        }
        Arrays.sort(ansArr, (a, b) -> a[0] - b[0]);
        return ansArr;
    }

}
