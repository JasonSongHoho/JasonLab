package lab.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/21
 */
@Slf4j
public class H84 {
    public static void main(String[] args) {
        log.info("{}", largestRectangleArea(new int[]{2}));
        log.info("{}", largestRectangleArea(new int[]{2,2}));
        log.info("{}", largestRectangleArea(new int[]{100,1,8,8}));
        log.info("{}", largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int cur;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            cur = heights[i];
            int top;
            while (queryPeeked((top = stack.peek()), heights) >= cur) {
                right[top] = i;
                stack.pop();
            }
            if (i > 0) {
                left[i] = Math.max(top + 1, 0);
            }
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i]) * heights[i]);
        }
        return ans;
    }

    private static int queryPeeked(int index, int[] heights) {
        if (index < 0) {
            return -1;
        } else {
            return heights[index];
        }
    }
}
