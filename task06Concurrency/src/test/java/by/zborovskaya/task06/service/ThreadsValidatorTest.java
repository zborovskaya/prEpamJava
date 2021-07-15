package by.zborovskaya.task06.service;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ThreadsValidatorTest {
    ThreadsValidator validator= new ThreadsValidator();

    @Test
    public void testIsValid() {
        List<String> data = DAOFactory.getInstance().getMatrixDAOImpl()
                .readData("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataThreads.txt");
        boolean result=validator.isValid(data);
        Assert.assertEquals(result, true);
    }
}