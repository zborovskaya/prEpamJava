package by.training.task03.service;

import by.training.task03.entity.Array;


public class BubbleSort implements Sorting{
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */

    public void sort(Array array, boolean isIncreasing) {
        int length = array.getLength();
            for (int i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if(isIncreasing) {
                        if (array.getValue(j) > array.getValue(j + 1)) {
                            array.swap(j, j + 1);
                        }
                    } else {
                        if (array.getValue(j) < array.getValue(j + 1)) {
                            array.swap(j, j + 1);
                    }
                    }
                }
            }

    }
}
