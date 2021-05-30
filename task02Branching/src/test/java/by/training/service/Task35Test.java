package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task35Test {

    Task35 task35= new Task35();

    @DataProvider(name="dataForTestFindDate")
    public Object[][] createDataForTestFindDate() {
        return new Object[][] {
                {200,new int[]{19,7}},
                {366,null},
                {-5,null}
        };
    }

    @Test(description = "Positive and negative numbers dataset for FindDate test",
            dataProvider = "dataForTestFindDate")
    public void testFindDate(int input,int[] answer) {
        int[] result= task35.findDate(input);
        Assert.assertEquals(result, answer);
    }
}