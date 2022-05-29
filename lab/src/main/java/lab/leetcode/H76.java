package lab.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * @author Jason/XiaoJie
 * @date 2022/5/29
 */
public class H76 {
    /**
     * 滑动窗口，写起来太麻烦了
     */
//    public String minWindow(String s, String t) {
//        char[] charsS = s.toCharArray();
//        char[] charsT = t.toCharArray();
//        int m = charsS.length;
//        int n = charsT.length;
//        int cnt;
//        Map<Character,Integer> mapS = new HashMap<>();
//        Map<Character,Integer> mapT = new HashMap<>();
//        for(int i = 0; i < m; i++){
//            cnt = mapS.getOrDefault(charsS[i], 0);
//            mapS.put(charsS[i], cnt + 1);
//        }
//        for(int i = 0; i < n; i++){
//            cnt = mapT.getOrDefault(charsT[i], 0);
//            mapT.put(charsT[i], cnt + 1);
//        }
//        mapT.forEach((k,v) -> {
//            Integer cnt = mapS.get(k);
//            if(cnt == null || cnt < v){
//                return "";
//            }
//        });
//        String minWindow = s;
//        int l = 0, r = 0;
//        Map<Character,Integer> cntMap = new HashMap<>();
    //起始窗口可以从n的长度开始
//        for(int i = 0; i < m; i++){
//            char c = charsS[i];
//            cnt = mapT.getOrDefault(c, 0);
    //校验是否满足数量要求，不满足则窗口加宽，否则尝试缩短。
//            if(){
//            }
//        }
//        return minWindow;
//
//    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();

        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                ++r;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }

}
