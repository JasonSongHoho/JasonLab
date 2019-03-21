package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jasonsong
 * 2019/3/21
 * <p>
 * <p>
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * <p>
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */


public class E605 {
    private static final Logger LOGGER = LoggerFactory.getLogger(M524.class);

    public static void main(String[] args) {
        E605 e605 = new E605();
//        int[] flowerbed = {1, 0, 0, 0, 0};
//        int[] flowerbed = {1, 0, 1, 0, 1, 0, 1};
//        int[] flowerbed = {0,0,1,0,1};
        int[] flowerbed = {0};
        int n = 1;

        LOGGER.info("input:{} {}", flowerbed, n);
        LOGGER.info("output:{}", e605.canPlaceFlowers(flowerbed, n));

    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }
        int result = 0;
        int l = flowerbed.length;
        if (l == 1 && flowerbed[0] == 0 ) {
            flowerbed[0] = 1;
            result++;
            if (result >= n) {
                return true;
            }
        }
        if (l > 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            result++;
            if (result >= n) {
                return true;
            }
        }
        for (int i = 1; i < l - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                result++;
                if (result >= n) {
                    return true;
                }
            }
        }

        if (l > 1 && flowerbed[l - 2] == 0 && flowerbed[l - 1] == 0) {
            flowerbed[l - 1] = 1;
            result++;
            if (result >= n) {
                return true;
            }
        }
        return false;
    }
}
