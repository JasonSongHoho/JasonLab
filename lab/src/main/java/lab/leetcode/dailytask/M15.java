package lab.leetcode.dailytask;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * r1=0-r2-r3;
 * <p>
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author jasonsong
 * 2020/6/12
 */


public class M15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {-1, 0, 1, 2, -1, -4, 4, 6, 7, 8, 23, -11, 12, -12, 0, 0, -15, -5, 20, 11, 9, -20};
        System.out.println(JSON.toJSONString(threeSum(nums1)));
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        System.out.println(JSON.toJSONString(nums));
        int low = 0;
        int high = nums.length - 1;
        int i = low, j = high, k = (j + i) / 2;
        while (i < j - 1 && nums[i] < 1 && nums[j] > -1) {
            while (j > i + 1 && nums[j] > -1) {
                int tempTotal = nums[i] + nums[j];
                int lt = i;
                int ht = j;
                while (k > i && k < j && lt < ht - 1) {
                    if (nums[k] + tempTotal == 0) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        result.add(item);
                        j--;
                        break;
                    } else if (nums[k] + tempTotal < 0) {
                        lt = k;
                        k = (k + ht) / 2;
                    } else {
                        ht = k;
                        k = (k + lt) / 2;
                    }
                }
                if (nums[i] + nums[j] + nums[j - 1] < 0) {
                    low++;
                    break;
                }
                if (nums[i] + nums[i + 1] + nums[j] > 0) {
                    high--;
                    break;
                }
            }
            i = low;
            j = high;
            k = (j + i) / 2;
        }

        return result;
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


}
