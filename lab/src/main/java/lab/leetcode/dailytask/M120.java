package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * @author jasonsong
 * 2020/7/14
 */


public class M120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        if (height == 0) {
            return 0;
        } else if (height == 1) {
            return triangle.get(0).get(0);

        }
        int[] total = new int[height];
        total[0] = triangle.get(0).get(0);
        int[] temp;
        int val;
        for (int i = 1; i < height; i++) {
            temp = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                val = triangle.get(i).get(j);
                if (j == 0) {
                    temp[j] = total[j] + val;
                } else if (j == i) {
                    temp[j] = total[j - 1] + val;
                } else {
                    temp[j] = Math.min(total[j], total[j - 1]) + val;
                }
            }
            total = Arrays.copyOf(temp, temp.length);
        }
        int result = Integer.MAX_VALUE;
        for (int value : total) {
            result = Math.min(result, value);
        }
        return result;
    }

}
