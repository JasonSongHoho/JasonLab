package lab.leetcode;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/22
 */
public class M238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int mul = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            answer[i] = answer[i] * mul;
            mul *= nums[i];
        }
        return answer;
    }
}
