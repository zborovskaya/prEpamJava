package by.training.task03.service;

import by.training.task03.entity.Array;


public class ShakerSort implements Sorting{
    /**
     * The function sort array
     * @param array
     * @param isIncreasing
     */
    public void sort(Array array, boolean isIncreasing) {
        int leftSide = 0;
        int rightSide = array.getLength() - 1;
        if(isIncreasing) {
            do {
                for (int i = leftSide; i < rightSide; i++) { // Сортир. влево ищем МАКС. знач.
                    if (array.getValue(i) > array.getValue(i + 1)) {
                        array.swap(i, i + 1);
                        //TODO позиция последнего обмена
                    }
                }
                rightSide--; // Уменьшаем количество проходов
                for (int i = rightSide; i > leftSide; i--) { // Теперь идём в обратную сторону ищем МИН.
                    if (array.getValue(i) < array.getValue(i - 1)) {
                        array.swap(i, i - 1);
                    }
                }
                leftSide++; // Уменьшаем количество проходов т.к. мы шли с конца исходя из условия
                // последнего for, что бы уменьшить кол-во проходокб нужно инкрементировать счётчик
            } while (leftSide < rightSide); // Априори наше условие при котором буду происходить
            // проходки
        } else {
            do {
                for (int i = leftSide; i < rightSide; i++) { // Сортир. влево ищем МАКС. знач.
                    if (array.getValue(i) < array.getValue(i + 1)) {
                        array.swap(i, i + 1);
                    }
                }
                rightSide--; // Уменьшаем количество проходов
                for (int i = rightSide; i > leftSide; i--) { // Теперь идём в обратную сторону ищем МИН.
                    if (array.getValue(i) > array.getValue(i - 1)) {
                        array.swap(i, i - 1);
                    }
                }
                leftSide++; // Уменьшаем количество проходов т.к. мы шли с конца исходя из условия
                // последнего for, что бы уменьшить кол-во проходокб нужно инкрементировать счётчик
            } while (leftSide < rightSide); // Априори наше условие при котором буду происходить
            // проходки
        }
    }
}
