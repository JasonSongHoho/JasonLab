package lab.leetcode.common;

/**
 * @author jasonsong
 * 2020/7/5
 */


public class Heap {
    int[] values;
    int count = 0;
    int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        values = new int[capacity + 1];
    }


    public Boolean insert(int data) {
        if (capacity == count) {
            return false;
        }
        count++;
        int index = count + 1;
        values[index] = data;
        while (true) {
            int parentIndex = index / 2;
            if (parentIndex > 0 && values[parentIndex] < data) {
                swap(values, index, parentIndex);
            } else {
                break;
            }
        }
        return true;
    }

    public Boolean deleteMax() {
        if (count == 0) {
            return false;
        }
        values[1] = values[count];
        values[count--] = 0;
        heapifyFromTop();
        return true;
    }

    private void heapifyFromTop() {
        int max = values[1];
        int index = 1;
        int nextIndex;
        int left;
        int right;
        while (true) {
            nextIndex = left = 2 * index;
            right = left + 1;
            if (left <= count && values[left] > values[index]) {
                swap(values, left, index);
                nextIndex = left;
            }
            if (right <= count && values[right] > values[index]) {
                swap(values, right, index);
                nextIndex = right;
            }
            if (max == values[index]) {
                break;
            } else {
                index = nextIndex;
            }

        }
    }


    private void swap(int[] values, int a, int b) {
        int tmp = values[a];
        values[a] = values[b];
        values[b] = tmp;
    }


}
