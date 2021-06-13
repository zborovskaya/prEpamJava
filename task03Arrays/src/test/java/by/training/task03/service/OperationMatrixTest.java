package by.training.task03.service;

import by.training.task03.entity.Matrix;
import by.training.task03.service.exception.MatrixException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OperationMatrixTest {

    OperationMatrix operationMatrix= new OperationMatrix();

    @Test
    public void testMultiply() {
        try {
            Matrix matrix1 = new Matrix(new int[][]{{6, 7, 3}, {9, 0, 1}, {5, 8, 7}});
            Matrix matrix2 = new Matrix(new int[][]{{5, 1, 0}, {4, 10, 2}, {1, 1, 1}});
            Matrix expected = new Matrix(new int[][]{{61, 79, 17}, {46, 10, 1}, {64, 92, 23}});

            Matrix result = operationMatrix.multiply(matrix1, matrix2);
            assertEquals(result, expected);
        }
        catch(MatrixException e){}
    }

    @Test
    public void testSum() {
        try {
            Matrix matrix1 = new Matrix(new int[][]{{6, 7, 3}, {9, 0, 1}, {5, 8, 7}});
            Matrix matrix2 = new Matrix(new int[][]{{5, 1, 0}, {4, 10, 2}, {1, 1, 1}});
            Matrix expected = new Matrix(new int[][]{{11, 8, 3}, {13, 10, 3}, {6, 9, 8}});
            Matrix result = operationMatrix.sum(matrix1, matrix2);
            assertEquals(result, expected);
        }
        catch(MatrixException e){}

    }

    @Test
    public void testCalcdifference() {
        try {
            Matrix matrix1 = new Matrix(new int[][]{{6, 7, 3}, {9, 0, 1}, {5, 8, 7}});
            Matrix matrix2 = new Matrix(new int[][]{{5, 1, 0}, {4, 10, 2}, {1, 1, 1}});
            Matrix expected = new Matrix(new int[][]{{1, 6, 3}, {5, -10, -1}, {4, 7, 6}});
            Matrix result = operationMatrix.calcdifference(matrix1, matrix2);
            assertEquals(result, expected);
        }
        catch(MatrixException e){}
    }
}