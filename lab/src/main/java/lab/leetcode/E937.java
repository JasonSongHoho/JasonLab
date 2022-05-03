package lab.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason/XiaoJie
 * @date 2022/5/3
 */
public class E937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitalList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();
        judgeList(logs, digitalList, letterList);
        sortLetter(letterList);
        return mergeList(letterList, digitalList);
    }

    private void judgeList(String[] logs, List<String> digitalList, List<String> letterList) {
        for (String logStr : logs) {
            String[] logLetArr = logStr.split(" ");
            if (logLetArr.length > 1) {
                Integer digVal = null;
                try {
                    digVal = Integer.parseInt(String.valueOf(logLetArr[1].charAt(0)));
                } catch (Throwable t) {
                }
                if (digVal != null) {
                    digitalList.add(logStr);
                } else {
                    letterList.add(logStr);
                }
            }
        }
    }

    private void sortLetter(List<String> letterList) {
        letterList.sort((a, b) -> {
            String[] letterAArr = a.split(" ", 2);
            String[] letterBArr = b.split(" ", 2);
            int compareResult = letterAArr[1].compareTo(letterBArr[1]);
            if (compareResult != 0) {
                return compareResult;
            } else {
                return letterAArr[0].compareTo(letterBArr[0]);
            }
        });
    }

    private String[] mergeList(List<String> letterList, List<String> digitalList) {
        int size = letterList.size() + digitalList.size();
        String[] resultArr = new String[size];
        int i = 0;
        for (String letter : letterList) {
            resultArr[i++] = letter;
        }
        for (String digital : digitalList) {
            resultArr[i++] = digital;
        }
        return resultArr;
    }
}
