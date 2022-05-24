package lab.real.t2022;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回响科技
 * 非零整数数组排序，要求：
 * - 正数在前，负数在后
 * - 正数从大到小
 * - 负数从小到大
 *
 * @author Jason/XiaoJie
 * @date 2022/5/23
 */
@Slf4j
public class HuiXiangTest {
    public static void main(String[] args) {
        log.info("{}", sort(new int[]{1, 3, -2, 8, -5, 43, 2, -1, 6, 7}));
    }

    public static int[] sort(int[] nums) {
        int length = nums.length;
        for (int i = 0, j = length - 1; i < j; i++) {
            while (nums[j] < 0 && i < j) {
                j--;
            }
            while (nums[i] > 0 && i < j) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<Integer> sortOld(int[] nums) {
        List<Integer> resultList;
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positiveList.add(num);
            } else {
                negativeList.add(num);
            }
        }
        Collections.sort(positiveList, (a, b) -> b - a);
        Collections.sort(negativeList);
        resultList = positiveList;
        resultList.addAll(negativeList);
        return resultList;
    }
}
