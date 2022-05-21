package lab.leetcode.bytedance;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * @author jasonsong
 * 2020/9/20
 */


public class H42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }

        int left = 0, right = length - 1, leftMax = height[0], rightMax = height[length - 1];
        int total = 0;
        while (left < right) {
            if (leftMax <= rightMax) {
                while (leftMax <= rightMax && left < right) {
                    left++;
                    if (leftMax <= height[left]) {
                        leftMax = height[left];
                    } else {
                        total += leftMax - height[left];
                    }
                }
            } else {
                while (leftMax > rightMax && left < right) {
                    right--;
                    if (rightMax <= height[right]) {
                        rightMax = height[right];
                    } else {
                        total += rightMax - height[right];
                    }
                }
            }
        }
        return total;
    }

    public int trap1(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int ans = 0, l = 0, r = n - 1, lm = height[0], rm = height[r], h;
        while (l < r) {
            if (lm <= rm) {
                h = height[l];
                if (h >= lm) {
                    lm = h;
                } else {
                    ans += lm - h;
                }
            } else {
                h = height[r];
                if (h >= rm) {
                    rm = h;
                } else {
                    ans += rm - h;
                }
            }
            if (lm > rm) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
