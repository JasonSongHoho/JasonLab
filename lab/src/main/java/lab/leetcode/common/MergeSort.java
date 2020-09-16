package lab.leetcode.common;

/**
 * @author jasonsong
 * 2020/7/5
 */


public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {11, 44, 23, 67, 88, 65, 34, 48, 9, 12};
        int[] arr = {10, 6, 6, 3, 8, 33, 27, 66, 9, 9, 7, 88};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
//
//    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            mergeSort(arr, low, mid, tmp); //对左边序列进行归并排序
//            mergeSort(arr, mid + 1, high, tmp);  //对右边序列进行归并排序
//            merge(arr, low, mid, high, tmp);    //合并两个有序序列
//        }
//    }
//
//
//    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
//        int i = 0;
//        //左边序列和右边序列起始索引
//        int j = low, k = mid + 1;
//        while (j <= mid && k <= high) {
//            if (arr[j] < arr[k]) {
//                tmp[i++] = arr[j++];
//            } else {
//                tmp[i++] = arr[k++];
//            }
//        }
//        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
//        while (j <= mid) {
//            tmp[i++] = arr[j++];
//        }
//
//        while (k <= high) {
//            tmp[i++] = arr[k++];
//        }
//
//        for (int t = 0; t < i; t++) {
//            arr[low + t] = tmp[t];
//        }
//    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[arr.length];
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }
        for (int m = start; m <= end; m++) {
            arr[m] = tmp[m];
        }
    }

}
