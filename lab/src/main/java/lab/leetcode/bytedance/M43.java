package lab.leetcode.bytedance;

/**
 * @author jasonsong
 * 2020/7/18
 */


public class M43 {
    public static void main(String[] args) {
        //6
        System.out.println(multiply("2", "3"));
        //3071640
        System.out.println(multiply("312", "9845"));
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


    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 90.95%
     * 的用户
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        if ((num1.length() == 1 && Integer.valueOf(num1) == 0) ||
                (num2.length() == 1 && Integer.valueOf(num2) == 0)) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

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
