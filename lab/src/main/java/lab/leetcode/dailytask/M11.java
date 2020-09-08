package lab.leetcode.dailytask;

/**
 * @author jasonsong
 * 2020/9/8
 */


public class M11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 8}));
        System.out.println(maxArea(new int[]{3, 10, 8}));
        System.out.println(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        int maxI = height[i];
        while (i < height.length) {
            int maxJ = height[j];
            while (i < j) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
                while (--j > i) {
                    if (height[j] > maxJ) {
                        maxJ = height[j];
                        break;
                    }
                }
            }
            j = height.length - 1;
            while (++i < height.length) {
                if (height[i] > maxI) {
                    maxI = height[i];
                    break;
                }
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
