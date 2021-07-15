package by.zborovskaya.task06.service;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.service.validator.MatrixValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MatrixValidatorTest {
    MatrixValidator validator= new MatrixValidator();

    @Test
    public void testIsValid() {
        List<String> data = DAOFactory.getInstance().getMatrixDAOImpl()
                .readData("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataMatrix.txt");
        boolean result=validator.isValid(data);
        Assert.assertEquals(result, true);
    }
}