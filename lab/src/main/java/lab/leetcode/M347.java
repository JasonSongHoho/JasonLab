package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jasonsong
 * 2019/3/22
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */


public class M347 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M524.class);

    public static void main(String[] args) {
        M347 m347 = new M347();
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3};
        int[] nums1 = {2, 2, 2, 2};
        int[] nums2 = {2, 2, 3, 3};
        int n = 2;

        LOGGER.info("input:{} {} . output:{}", nums, n, m347.topKFrequent1(nums, n));
        LOGGER.info("input:{} {} . output:{}", nums1, 1, m347.topKFrequent1(nums1, 1));
        LOGGER.info("input:{} {} . output:{}", nums2, n, m347.topKFrequent1(nums2, n));

    }


    public int[] topKFrequent1(int[] nums, int k) {
        //<num,count>
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int num : nums) {
            Integer count = numMap.getOrDefault(num, 0);
            numMap.put(num, ++count);
        }
        //<count,nums>
        HashMap<Integer, List<Integer>> countMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            List<Integer> numbList = countMap.getOrDefault(entry.getValue(), new ArrayList<>());
            numbList.add(entry.getKey());
            countMap.put(entry.getValue(), numbList);
        }
        Integer[] sortedCountArray = numMap.values().toArray(new Integer[numMap.size()]);
        Arrays.sort(sortedCountArray, (o1, o2) -> o2 - o1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.addAll(countMap.get(sortedCountArray[i]));
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i++] = integer;
        }
        return result;
    }


//
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> ret = new ArrayList<>();
//        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
//        Map<Integer, Integer> sourceMap = new HashMap<>(nums.length);
//        Map<Integer, List<Integer>> sinkMap = new TreeMap<>(comparator);
//        for (int num : nums) {
//            sourceMap.put(num, sourceMap.getOrDefault(num, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : sourceMap.entrySet()) {
//            List<Integer> list = sinkMap.getOrDefault(entry.getValue(),new ArrayList<>());
//            list.add(entry.getKey());
//            sinkMap.put(entry.getValue(), list);
//        }
//        int i = 0;
//        for (Map.Entry<Integer, List<Integer>> entry : sinkMap.entrySet()) {
//            if (i < k) {
//                List<Integer> integerList = entry.getValue();
//                i = ret.size() + integerList.size();
//                ret.addAll(entry.getValue());
//                for (; i > k; i--) {
//                    ret.remove(i-1);
//                }
//            } else {
//                break;
//            }
//        }
//        return ret;
//    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for (int i = bucket.length - 1; i >= 0 && ret.size() < k; i--) {
            if (bucket[i] != null) {
                ret.addAll(bucket[i]);
            }
        }
        return ret;
    }
}
