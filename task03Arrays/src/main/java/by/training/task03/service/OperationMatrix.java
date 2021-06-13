package by.training.task03.service;

import by.training.task03.entity.Matrix;
import by.training.task03.service.exception.MatrixException;

public class OperationMatrix {
    /**
     * The function multiplies matrices
     * @param p first matrix
     * @param q second matrix
     * @return
     * @throws MatrixException
     */
    public  Matrix multiply(Matrix p, Matrix q) throws MatrixException {
        int v = p.getVerticalSize();
        int h = q.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (controlSize != q.getVerticalSize()) {
            throw new MatrixException("incompatible matrices");
        }
        Matrix result = new Matrix(v, h);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += p.getElement(i, k) * q.getElement(k, j);
                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (MatrixException e) {
            // log: exception impossible
        }
        return result;
    }

    /**
     * The function sums matrices
     * @param p first matrix
     * @param q second matrix
     * @return
     * @throws MatrixException
     */
    public  Matrix sum(Matrix p, Matrix q) throws MatrixException {

        int v = p.getVerticalSize();
        int h = p.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (v!= q.getVerticalSize() && h!=q.getHorizontalSize()) {
            throw new MatrixException("incompatible matrices");
        }
        Matrix result = new Matrix(v, h);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {

                    result.setElement(i, j, p.getElement(i,j)+q.getElement(i,j));
                }
            }
        } catch (MatrixException e) {
            // log: exception impossible
        }
        return result;
    }
    /**
     * The function calculate difference
     * @param p first matrix
     * @param q second matrix
     * @return
     * @throws MatrixException
     */
    public  Matrix calcdifference(Matrix p, Matrix q) throws MatrixException {

        int v = p.getVerticalSize();
        int h = p.getHorizontalSize();
        int controlSize = p.getHorizontalSize();
        if (v!= q.getVerticalSize() && h!=q.getHorizontalSize()) {
            throw new MatrixException("incompatible matrices");
        }
        Matrix result = new Matrix(v, h);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {

                    result.setElement(i, j, p.getElement(i,j)-q.getElement(i,j));
                }
            }
        } catch (MatrixException e) {
            // log: exception impossible
        }
        return result;
    }


}
