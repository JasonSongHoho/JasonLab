package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jasonsong
 * 2018/12/23
 */


public class E1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(E1.class);

    public static void main(String[] args) {
        E1 e1 = new E1();
        int[] nums = {2, 1, 5, 3, 7, 10, 15};
        int[] nums1 = {3, 2, 4};
        int target = 18;
        int target1 = 6;
        LOGGER.info("result:{}", e1.twoSum(nums, target));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int con;
        for (int i = 0; i < nums.length; i++) {
            con = target - nums[i];
            if (map.containsKey(con)) {
                //若找到，直接返回
                return new int[]{map.get(con), i};
            }
            //没找到，且数组没有遍历完，继续添加
            map.put(nums[i], i);
        }
        return null;
    }

}
