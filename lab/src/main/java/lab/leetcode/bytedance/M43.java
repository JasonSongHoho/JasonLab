package lab.leetcode.bytedance;

/**
 * @author jasonsong
 * 2020/7/18
 */


public class M43 {
    public static void main(String[] args) {
        //6
        System.out.println(multiply("2", "3").equals("" + 2 * 3));
        //3071640
        System.out.println(multiply("312", "9845").equals("" + 312 * 9845));
        System.out.println(multiply("12", "9845").equals("" + 12 * 9845));
        //726
        System.out.println(multiply("22", "33"));
        //100
        System.out.println(multiply("10", "10"));
        //9702
        System.out.println(multiply("99", "98"));
        //8991
        System.out.println(multiply("999", "9"));
        //9801
        System.out.println(multiply("99", "99"));
    }

    public static String multiply(String num1, String num2) {
        if ((num1.length() == 1 && Integer.valueOf(num1) == 0) ||
                (num2.length() == 1 && Integer.valueOf(num2) == 0)) {
            return "0";
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] result = new int[char1.length + char2.length + 2];
        for (int i = char1.length - 1; i >= 0; i--) {
            for (int j = char2.length - 1; j >= 0; j--) {
                int m = char1[i] - '0', n = char2[j] - '0';
                int pos = char1.length - 1 - i + char2.length - 1 - j;
                int value = m * n;
                while (value > 0) {
                    int v = result[pos];
                    v += value;
                    result[pos++] = v % 10;
                    value = v / 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.insert(0, i);
        }
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0'){
                start++;
            }else {
                break;
            }
        }
        return sb.substring(start);
    }

//
//
//    /**
//     * 执行用时：
//     * 4 ms
//     * , 在所有 Java 提交中击败了
//     * 90.95%
//     * 的用户
//     * @param num1
//     * @param num2
//     * @return
//     */
//    public static String multiply(String num1, String num2) {
//        if ((num1.length() == 1 && Integer.valueOf(num1) == 0) ||
//                (num2.length() == 1 && Integer.valueOf(num2) == 0)) {
//            return "0";
//        }
//        int[] res = new int[num1.length() + num2.length()];
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            int n1 = num1.charAt(i) - '0';
//            for (int j = num2.length() - 1; j >= 0; j--) {
//                int n2 = num2.charAt(j) - '0';
//                int sum = (res[i + j + 1] + n1 * n2);
//                res[i + j + 1] = sum % 10;
//                res[i + j] += sum / 10;
//            }
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < res.length; i++) {
//            if (i == 0 && res[i] == 0) continue;
//            result.append(res[i]);
//        }
//        return result.toString();
//    }

    /**
     * 执行用时：
     * 11 ms
     * , 在所有 Java 提交中击败了
     * 40.74%
     * 的用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply1(String num1, String num2) {
        if ((num1.length() == 1 && Integer.valueOf(num1) == 0) ||
                (num2.length() == 1 && Integer.valueOf(num2) == 0)) {
            return "0";
        }
        int[] cache = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int numI = num1.charAt(i) - 48;
            if (numI == 0) {
                continue;
            }
            for (int j = num2.length() - 1; j >= 0; j--) {
                int numJ = num2.charAt(j) - 48;
                if (numJ == 0) {
                    continue;
                }
                int temp = numJ * numI;
                setVal(cache, num1.length() + num2.length() - i - j - 2, temp);
            }
        }
        int startIndex = cache.length - 1;
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] != 0) {
                startIndex = i;
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i >= 0; i--) {
            result.append(cache[i]);
        }
        return result.toString();
    }


    private static void setVal(int[] cache, int index, int value) {
        cache[index] += value;
        for (int i = index; i < cache.length - 1; i++) {
            if (cache[i] >= 10) {
                cache[i + 1] += cache[i] / 10;
                cache[i] = cache[i] % 10;
            } else {
                break;
            }
        }
    }


}
