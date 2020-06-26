package lab.leetcode.dailytask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
 * ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
 *
 * @author jasonsong
 * 2020/6/25
 */


public class M139 {
    static Map<String, Boolean> mem = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(wordBreak0("applepie",Arrays.asList("pie","pear","apple","peach") ));
//        System.out.println(wordBreak1("applepenapple",Arrays.asList("apple", "pen") ));
//        System.out.println(wordBreak1("appleaaaaapple", Arrays.asList("apple", "pen", "aaa")));
//        System.out.println(wordBreak1("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
//                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa") ));

    }


    public static boolean wordBreak0(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> realWordDict = new HashSet<>();
        for (String word : wordDict) {
            if (s.contains(word)) {
                realWordDict.add(word);
            }
        }
        return helper(s, realWordDict);
    }

    public static boolean helper(String s, Set<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        List<String> prefixWords = new ArrayList<>();
        List<String> suffixWords = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                prefixWords.add(word);
            }
            if (s.endsWith(word)) {
                suffixWords.add(word);
            }
        }
        if (prefixWords.isEmpty() || suffixWords.isEmpty()) {
            return false;
        }

        for (String prefixWord : prefixWords) {
            for (String suffixWord : suffixWords) {
                if (prefixWord.length() > s.length() - suffixWord.length()) {
                    if (helper(s.substring(prefixWord.length()), wordDict)) {
                        return true;
                    }
                } else {
                    String substring = s.substring(prefixWord.length(), s.length() - suffixWord.length());
                    Boolean canPattern = mem.get(substring);
                    if (canPattern == null) {
                        boolean pattern = helper(substring, wordDict);
                        mem.put(substring, pattern);
                        if (pattern) {
                            return true;
                        }
                    } else if (canPattern) {
                        return true;
                    }

                }
            }
        }

        return false;
    }

//todo 待优化
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String substring = s.substring(word.length());
                Boolean canPattern = mem.get(substring);
                if (canPattern == null) {
                    boolean pattern = wordBreak2(substring, wordDict);
                    mem.put(substring, pattern);
                    if (pattern) {
                        return true;
                    }
                } else if (canPattern) {
                    return true;
                }
            }
        }
        return false;
    }

}
