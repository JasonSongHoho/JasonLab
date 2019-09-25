package lab.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jasonsong
 * 2019/9/25
 */

@Slf4j
public class E441 {
    public static void main(String[] args) {
        E441 e441 = new E441();
        int[] testArr = {2, 1, 5, 6, 3, 7, 11, 15};
        for (int item : testArr) {
            int result = e441.arrangeCoins(item);
            log.info("n:{}, result:{}", item, result);

        }

    }


    public int arrangeCoins(int n) {
        int l = 0, h = n;
        while (l <= h) {
            int m = l + (h - l) / 2;
            long x = m * (m + 1L) / 2;
            if (x == n) {
                return m;
            } else if (x < n) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }

//
//    public int arrangeCoins(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        int l = 0, h = n, m, total;
//        while (l<=h) {
//            m = l + (h - l) / 2;
//            total = getTotal(m);
//            if (total == n) {
//                return m;
//            } else if (total > n) {
////                total = getTotal(m - 1);
////                if (total < n) {
////                    return m - 1;
////                }
//                h = m - 1;
//            } else {
////                total = getTotal(m + 1);
////                if (total > n) {
////                    return m;
////                }
//                l = m + 1;
//            }
//        }
//        return h;
//    }
//
//    private int getTotal(int m) {
//        return (1 + m) * m / 2;
//    }
//

}
