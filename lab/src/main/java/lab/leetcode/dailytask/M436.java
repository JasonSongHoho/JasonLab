package lab.leetcode.dailytask;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/20
 */
@Slf4j
public class M436 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 7}, {3, 4}, {0, 1}, {4, 8}};
//        int[][] sortByLeftArr = Arrays.copyOf(intervals, intervals.length);
//        int[][] sortByRightArr = Arrays.copyOf(intervals, intervals.length);
//        Arrays.sort(sortByLeftArr, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(sortByRightArr, Comparator.comparingInt(a -> a[1]));
//        log.info(Arrays.deepToString(sortByLeftArr));
//        log.info(Arrays.deepToString(sortByRightArr));

//        List<Integer> sortedByLeftList = new ArrayList<>(Arrays.asList(2, 3, 5));
//
//        log.info("" + Collections.binarySearch(sortedByLeftList, 0));
//        log.info("" + Collections.binarySearch(sortedByLeftList, 2));
//        log.info("" + Collections.binarySearch(sortedByLeftList, 4));
//        log.info("" + Collections.binarySearch(sortedByLeftList, 5));
//        log.info("" + Collections.binarySearch(sortedByLeftList, 7));

        int[] rightInterval = findRightInterval(intervals);
        log.info(Arrays.toString(rightInterval));
    }

    public static int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0], i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int num = intervals[i][1];
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(num);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }


    public static int[] findRightInterval1(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        List<Integer> sortedByLeftList = new ArrayList<>(map.keySet());
        Collections.sort(sortedByLeftList);
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int num = intervals[i][1];
            int index = Collections.binarySearch(sortedByLeftList, num);
            if (index < 0) {
                index = -index - 1;
                if (index >= intervals.length) {
                    result[i] = -1;
                    continue;
                }
            }
            Integer leftNum = sortedByLeftList.get(index);
            result[i] = map.get(leftNum);
        }
        return result;
    }
}
