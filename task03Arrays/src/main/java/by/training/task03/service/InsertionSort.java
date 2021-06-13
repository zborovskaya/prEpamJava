package by.training.task03.service;
import by.training.task03.entity.Array;

public class InsertionSort implements Sorting{
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */

    public void sort(Array array, boolean isIncreasing) {
        if (isIncreasing) {
            for (int i = 1; i < array.getLength(); i++) {
                int current = array.getValue(i);
                int j = i;
                while (j > 0 && array.getValue(j - 1) > current) {
                    array.setValues(j, array.getValue(j - 1));
                    j--;
                }
                array.setValues(j, current);
            }
        } else {
            for (int i = 1; i < array.getLength(); i++) {
                int current = array.getValue(i);
                int j = i;
                while (j > 0 && array.getValue(j - 1) < current) {
                    array.setValues(j, array.getValue(j - 1));
                    j--;
                }
                array.setValues(j, current);
            }
        }
    }
}
