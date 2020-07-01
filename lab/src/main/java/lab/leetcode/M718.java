package lab.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 718. 最长重复子数组
 * <p>
 * <p>
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * [70,39,25,40,7]
 * [52,20,67,5,31]
 *
 * @author jasonsong
 * 2020/7/1
 */


public class M718 {
    public static void main(String[] args) {

        int[] A2 = {5, 14, 53, 80, 48};
        int[] B2 = {50, 47, 3, 80, 83};
        System.out.println(findLength(A2, B2));

        int[] A1 = {8, 2, 3, 2, 1};
        int[] B1 = {3, 2, 1, 4, 7};
        System.out.println(findLength(A1, B1));

        int[] A = {70, 39, 25, 40, 7};
        int[] B = {52, 20, 67, 5, 31};
        System.out.println(findLength(A, B));

    }


    public static int findLength(int[] A, int[] B) {
        int ans = 0;
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                ans = Math.max(ans, dp[i + 1][j + 1]);
            }
        }
        return ans;
    }


    /**
     * DP
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * O(n*m)
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength0(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    /**
     * 滑动窗口 + HashMap
     * <p>
     * （性能差）
     *
     * @param A
     * @param B
     * @return
     */
    public static int findLength1(int[] A, int[] B) {
        Integer maxLength = 0;
        if (A.length > B.length) {
            int[] tmpArr = A;
            A = B;
            B = tmpArr;
        }

        String stringB = Arrays.toString(B).replace(" ", "")
                .replace("[", ",").replace("]", ",");
        Map<String, Boolean> patternMap = new HashMap<>();
        String temp = ",";
        for (int i = 0, j = 0; i < A.length; i++) {
            while (j < A.length) {
                Boolean pattern = patternMap.get(temp);
                if (pattern != null && !pattern) {
                    temp += A[j++] + ",";
                    patternMap.put(temp, pattern);
                    String substring = temp.substring(1);
                    temp = substring.substring(substring.indexOf(","));
                    break;
                }
                temp += A[j++] + ",";
                pattern = patternMap.get(temp);
                if (pattern == null) {
                    pattern = stringB.contains(temp);
                    patternMap.put(temp, pattern);
                }
                if (pattern) {
                    maxLength = j - i;
                } else {
                    String substring = temp.substring(1);
                    temp = substring.substring(substring.indexOf(","));
                    break;
                }
            }
        }
        return maxLength;
    }


}
