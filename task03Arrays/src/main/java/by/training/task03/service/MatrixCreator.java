package by.training.task03.service;

import by.training.task03.entity.Matrix;
import by.training.task03.service.exception.MatrixException;


public class MatrixCreator {

    /**
     * The function creates objects of the matrix class
     * @param n
     * @param m
     * @return
     * @throws MatrixException, if n<0, m<0
     */
    public Matrix create(int n, int m) throws MatrixException
    {
        Matrix matrix = null;
        if (isValid(n,m)) {
            matrix = new Matrix(n, m);
        }
        else throw new MatrixException("Matrix parameters entered incorrectly!");
        return matrix;
    }

    private boolean isValid(int n, int m)
    {
        return (n>0 && m>0);
    }


}
