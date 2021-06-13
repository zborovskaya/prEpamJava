package by.training.task03.service;

import by.training.task03.entity.Matrix;
import by.training.task03.service.exception.MatrixException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixCreatorTest {

    @Test(description = "Positive numbers dataset for testCreate")
    public void testCreatePositiv() {
        try {
            MatrixCreator matrixCreator= new MatrixCreator();
            Matrix matrix=matrixCreator.create(2,3);
            Matrix expected= new Matrix(2,3);
            assertEquals(matrix, expected);
        }
        catch(MatrixException e){}

    }

    @Test(description = "Negative numbers dataset for testCreate")
    public void testCreateNegative() {
        try {
            MatrixCreator matrixCreator= new MatrixCreator();
            Matrix matrix=matrixCreator.create(-1,3);
            assertEquals(matrix, null);
        }
        catch(MatrixException e){}

    }
}