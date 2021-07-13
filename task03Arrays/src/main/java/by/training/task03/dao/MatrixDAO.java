package by.training.task03.dao;

import by.training.task03.entity.Matrix;

public interface MatrixDAO {
    int[][] readMatrix1();
    int[][] readMatrix2();
    void write(Matrix matrix);
}
