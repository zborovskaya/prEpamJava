package by.training.task03.service;
import by.training.task03.entity.Array;

public class ShellSort implements Sorting{
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */

    public void sort(Array array, boolean isIncreasing) {
        if (isIncreasing) {
            int d = array.getLength() / 2;
            while (d > 0) {
                for(int i = 0; i < array.getLength() - d; i++) {
                    int j = i;
                    while ( j>= 0 && array.getValue(j) > array.getValue(j + d)) {
                        array.swap(j, j + d);
                        j--;
                    }
                }
                d = d / 2;
            }
        } else {
            int d = array.getLength() / 2;
            while (d > 0) {
                for(int i = 0; i < array.getLength() - d; i++) {
                    int j = i;
                    while ( j >= 0 && array.getValue(j) < array.getValue(j + d)) {
                        array.swap(j, j + d);
                        j--;
                    }
                }
                d = d / 2;
            }
        }
    }
}
