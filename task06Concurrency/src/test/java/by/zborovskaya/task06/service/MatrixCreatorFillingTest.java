package by.zborovskaya.task06.service;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MatrixCreatorFillingTest {
    MatrixCreatorFilling creator= new MatrixCreatorFilling();

    @Test
    public void testCreate() {
        SquareMatrix result=creator
                .create("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataMatrix.txt");
        SquareMatrix answer=new SquareMatrix(new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8},{1, 0, 2, 3, 4, 5, 6, 7, 8},
                {1, 2, 0, 3, 4, 5, 6, 7, 8},{1, 2, 3, 0, 4 ,5, 6, 7, 8},{1, 2, 3 ,4, 0, 6 ,7, 8, 9},
                {1, 2 ,3, 4, 5, 0, 7, 8, 9},{1, 2, 3, 4, 5 ,6, 0 ,8, 9}, {1, 2, 3, 4 ,5, 6 ,7 ,0 ,9},
                {1, 2, 3, 4, 5 ,6, 7 ,8, 0}});
        Assert.assertEquals(result, answer);
    }
}