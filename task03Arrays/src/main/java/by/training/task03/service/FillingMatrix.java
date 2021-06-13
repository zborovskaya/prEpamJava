package by.training.task03.service;

import by.training.task03.entity.Matrix;
import  by.training.task03.service.exception.MatrixException;
public class FillingMatrix {
    /**
     * The function fill matrix
     * @param matrix
     * @param minValue
     * @param maxValue
     */

    public void fillRandomized(Matrix matrix, int minValue, int maxValue) {
        int v = matrix.getVerticalSize();
        int h = matrix.getHorizontalSize();
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < h; j++) {
                try {
                    int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
                    matrix.setElement(i, j, value);
                } catch (MatrixException e) {
                    // log: exception impossible
                }
            }
        }
    }
}
