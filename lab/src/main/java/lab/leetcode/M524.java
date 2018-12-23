package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jasonsong
 * 2018/12/22
 */


public class M524 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M524.class);

    public static void main(String[] args) {
        M524 m524 = new M524();
        String s = "abpcplea";
        List<String> d = Arrays.asList("monkey", "ale", "apple", "please");
        LOGGER.info("input:{},output:{}", d, m524.findLongestWord(s, d));

    }

    public String findLongestWord(String s, List<String> d) {
        String ret = "";
        String[] strings = d.toArray(new String[0]);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });
        for (String str : strings) {
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j)) j++;
                if (j == str.length()) {
                    return str;
                }
            }
        }
        return ret;
    }


    /**
     * better func
     */
    public String findLongestWord2(String s, List<String> d) {
        String ret = "";
        for (String str : d) {
            for (int i = 0, j = 0; i < s.length() && j < str.length(); i++) {
                if (s.charAt(i) == str.charAt(j)) j++;
                if (j == str.length()) {
                    if (ret.length() < str.length()
                            || (ret.length() == str.length() && ret.compareTo(str) > 0)) {
                        ret = str;
                    }
                }
            }
        }
        return ret;
    }
}


