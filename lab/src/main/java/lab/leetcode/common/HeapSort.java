package lab.leetcode.common;

import java.util.Arrays;

/**
 * @author jasonsong
 * 2020/7/5
 */


public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 3, 4, 11, 9, 7};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        //构建大顶堆
        int[] heapArr = buildHeap(arr);
        //出堆、调整
        for (int i = heapArr.length - 1; i > 1; i--) {
            swapMax(heapArr, i);
        }
        return heapArr;
    }

    private static int[] buildHeap(int[] arr) {
        int count = arr.length;
        int[] heapArr = new int[count + 1];
        System.arraycopy(arr, 0, heapArr, 1, count);
        for (int i = count / 2; i > 0; i--) {
            int left = 2 * i;
            int right = left + 1;
            int swapIndex = 0;
            if (right <= count && heapArr[right] > heapArr[left]) {
                swapIndex = right;
            } else if (left <= count && heapArr[left] > heapArr[i]) {
                swapIndex = left;
            }
            if (swapIndex != 0) {
                swap(heapArr, swapIndex, i);
                heapify(heapArr, count, swapIndex);
            }
        }
        return heapArr;
    }


    public static void swapMax(int[] values, int index) {
        if (index <= 1) {
            return;
        }
        swap(values, index, 1);
        index--;
        heapify(values, index, 1);
    }

    private static void heapify(int[] values, int count, int index) {
        int nextIndex =index;
        int left;
        int right;
        while (true) {
            left = 2 * index;
            right = left + 1;
            if (left <= count && values[left] > values[index]) {
                nextIndex = left;
            }
            if (right <= count && values[right] > values[nextIndex]) {
                nextIndex = right;
            }
            if (index == nextIndex) {
                break;
            } else {
                swap(values, nextIndex, index);
                index = nextIndex;
            }
        }
    }


    private static void swap(int[] values, int a, int b) {
        int tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }


}
