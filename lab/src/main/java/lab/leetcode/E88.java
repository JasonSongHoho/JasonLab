package lab.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jasonsong
 * 2018/12/22
 */


public class E88 {
    private static final Logger LOGGER = LoggerFactory.getLogger(E88.class);

    public static void main(String[] args) {
        E88 e88 = new E88();
        int[][][] testArr = {{{1, 2, 3,0,0,0}, {2, 5, 6}}};
        for (int[][] item : testArr) {
            e88.merge(item[0], 3, item[1], item[1].length);
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1; // 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
        int idx = m + n - 1;
        while(i >= 0 || j >= 0){
            if(i < 0) nums1[idx] = nums2[j--];
            else if(j < 0) nums1[idx] = nums1[i--];
            else if(nums1[i] > nums2[j]) nums1[idx] = nums1[i--];
            else nums1[idx] = nums2[j--];
            idx--;
        }    }


}
