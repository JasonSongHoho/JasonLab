package lab.real.t2022;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/9
 */
public class Xtransfer {

    public static void main(String[] args) {
        System.out.println(method("abcbd"));
        System.out.println(method("abcde"));
    }

    public static int method(String str) {
        int len = str.length();
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= len; i++) {
            char c = str.charAt(i - 1);
            List<Integer> charPositionList = map.getOrDefault(c, new ArrayList<>());
            if (CollUtil.isEmpty(charPositionList)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                for (int position : charPositionList) {
                    if (check(position, i - 1, str)) {
                        dp[i] = dp[position] + 1;
                        break;
                    }
                }
                if (dp[i] == 0) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            map.put(c, charPositionList);
            charPositionList.add(i - 1);
        }
        return dp[len] - 1;
    }

    private static boolean check(int start, int end, String str) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
