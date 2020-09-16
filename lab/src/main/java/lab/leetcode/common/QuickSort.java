package lab.leetcode.common;

import java.util.Arrays;

/**
 * // 快速排序，A是数组，n表示数组的大小
 * quick_sort(A, n) {
 * quick_sort_c(A, 0, n-1)
 * }
 * // 快速排序递归函数，p,r为下标
 * quick_sort_c(A, p, r) {
 * if p >= r then return
 * <p>
 * q = partition(A, p, r) // 获取分区点
 * quick_sort_c(A, p, q-1)
 * quick_sort_c(A, q+1, r)
 * }
 * <p>
 * <p>
 * partition(A, p, r) {
 * pivot := A[r]
 * i := p
 * for j := p to r-1 do {
 * if A[j] < pivot {
 * swap A[i] with A[j]
 * i := i+1
 * }
 * }
 * swap A[i] with A[r]
 * return i
 *
 * @author jasonsong
 * 2020/6/27
 */


public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {10, 6, 6, 3, 8, 33, 27, 66, 9, 9, 7, 88};
        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int l = start, h = end, base = arr[l];
            while (l < h) {
                while (l < h && base <= arr[h]) {
                    h--;
                }
                arr[l] = arr[h];
                while (l < h && base >= arr[l]) {
                    l++;
                }
                arr[h] = arr[l];
            }
            arr[l] = base;
            sort(arr, start, l - 1);
            sort(arr, l + 1, end);
        }
    }

}
