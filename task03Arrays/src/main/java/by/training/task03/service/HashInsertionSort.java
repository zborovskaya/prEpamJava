package by.training.task03.service;

import by.training.task03.entity.Array;

import java.util.Arrays;

public class HashInsertionSort implements Sorting{
    public void sort(Array array, boolean isIncreasing) {
        if (isIncreasing) {
            int m = getMax(array.getArray(), array.getLength());
            for (int exp = 1; m/exp > 0; exp *= 10) {
                countSort(array.getArray(), array.getLength(), exp);
            }
        } else {
            int m = getMax(array.getArray(), array.getLength());
            for (int exp = 1; m/exp > 0; exp *= 10) {
                countSort(array.getArray(), array.getLength(), exp);
            }
            int[] arr = Arrays.copyOf(array.getArray(), array.getLength());
            int currIndex = 0;
            for(int itr = array.getLength() - 1; itr >= 0; itr--) {
                array.setValues(currIndex, arr[itr]);
                currIndex++;
            }
        }
    }

    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    static void countSort(int arr[], int n, int exp) {
        int[] output = new int[n]; // output array
        int i;
        int[] count = new int[10];
        Arrays.fill(count,0);
        for (i = 0; i < n; i++) {
            count[ (arr[i]/exp)%10 ]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
