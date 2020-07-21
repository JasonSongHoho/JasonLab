package lab.leetcode.dailytask;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author jasonsong
 * 2020/7/20
 */


public class E167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 6, 7, 11, 15}, 10)));
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int length = numbers.length;
        if (length < 2) {
            return new int[0];
        }
        for (int i = 0, j = length - 1; i < j; ) {
            int total = numbers[i] + numbers[j];
            if (total == target) {
                return new int[]{i + 1, j + 1};
            } else if (total > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }

    /**
     * 先左右各二分一次，再双指针。两边各二分一次后，两边的索引将十分接近目标索引，此时二分不如双指针。
     * @param numbers 输入数组
     * @param target 目标数
     * @return 返回两个下标，其和为目标数，从小到大
     */
    public  static int[] twoSum2(int[] numbers, int target) {
        // 输入校验
        if(numbers == null || numbers.length <= 1)
            return new int[]{-1,-1};
        int len = numbers.length;// 获得数组长度
        int left = 0,right = len-1;// 双指针
        int count = 2;// 左右各二分一次
        // 虽然说是一定找得到，不取等号是因为不能重复用同一个。
        while (left < right && count > 0){
            count--;//左右各二分一次
            int temp = numbers[left]+numbers[right];// 获得当前两数和
            int tempTarget;// 目标
            // 判断从右找还是从左找
            if(temp > target){
                tempTarget = target - numbers[left];
            }
            else if(temp < target)
                tempTarget = target - numbers[right];
            else
                return new int[]{left+1,right+1};
            // 二分搜索寻找指定目标的索引
            int tempL= left,tempR = right;
            // 仅剩一个数时直接返回避免死循环
            while (tempL < tempR) {
                int tempM = (tempL + tempR) / 2;
                if (numbers[tempM] < tempTarget)
                    tempL = tempM+1;
                    // 每次找到一个比目标值稍微大一点的数，所以上界保留
                else if (numbers[tempM] > tempTarget)
                    tempR = tempM;
                else
                    return temp>target? new int []{left+1,tempM+1}:new int []{tempM+1,right+1};
            }
            // tempL=tempR时跳出。tempM循环中断缺了一次计算中，不能用
            if(temp > target)
                right = tempL -1;
            else
                left = tempL;
        }
        while (left < right){
            int temp = numbers[left]+numbers[right];// 获得当前两数和
            if(temp > target)
                right--;
            else if(temp < target)
                left++;
                // 若找到
            else
                return new int[]{left+1,right+1};
        }
        return new int[]{-1,-1};
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        //先找到第一个大于等于 target-numbers[0] 的数字
        int pos=binarySearch(numbers,target-numbers[0]);
        int p1=0,p2=pos;
        while(p1<p2&&numbers[p1]+numbers[p2]!=target){
            while(p1<p2&&numbers[p1]+numbers[p2]<target)
                ++p1;
            while(p2>p1&&numbers[p1]+numbers[p2]>target)
                --p2;
        }
        res[0]=p1+1;
        res[1]=p2+1;
        return res;
    }

    public static int binarySearch(int[] numbers,int target){
        int left=0,right=numbers.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(numbers[mid]==target)
                return mid;
            else if(numbers[mid]>target)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }

    /**
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1,right + 1};
            }
            while(numbers[left] + numbers[right] > target){
                right--;
            }
            while(numbers[left] + numbers[right] < target){
                left++;
            }
        }
        return new int[]{-1,-1};
    }

}
