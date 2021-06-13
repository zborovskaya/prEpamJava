package by.training.task03.service;
import  by.training.task03.entity.Array;

public class SelectionSort implements Sorting {
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */
    public void sort(Array array, boolean isIncreasing) {
        if(isIncreasing) {
            for (int i = 0; i < array.getLength()-1; i++) {    // i - номер текущего шага
                int pos = i;
                int min = array.getValue(i);
                // цикл выбора наименьшего элемента
                for (int j = i + 1; j < array.getLength(); j++) {
                    if (array.getValue(j) < min) {
                        pos = j;    // pos - индекс наименьшего элемента
                        min = array.getValue(j);
                    }
                }
                array.setValues(pos, array.getValue(i));
                array.setValues(i, min); // меняем местами наименьший с array[i]
            }
        } else {
            for (int i = 0; i < array.getLength()-1; i++) {    // i - номер текущего шага
                int pos = i;
                int max = array.getValue(i);
                // цикл выбора наименьшего элемента
                for (int j = i + 1; j < array.getLength(); j++) {
                    if (array.getValue(j) > max) {
                        pos = j;    // pos - индекс наименьшего элемента
                        max = array.getValue(j);
                    }
                }
                array.setValues(pos, array.getValue(i));
                array.setValues(i, max); // меняем местами наименьший с array[i]
            }
        }
    }
}
