package lab.leetcode.jzoffer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * @author jasonsong
 * 2020/9/24
 */


public class JZ53II {
    public static void main(String[] args) {
    }
    public int missingNumber(int[] nums) {
        int l = 0 , r = nums.length - 1, m;
        while(l <= r){
            m = l + (r - l) / 2;
            if(nums[m] != m){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;


    }
}
