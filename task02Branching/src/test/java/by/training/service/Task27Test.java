package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task27Test {

    Task27 task27=new Task27();

    @DataProvider(name="dataForTestFindMaxAmongMin")
    public Object[][] createDataForTestFindMaxAmongMin() {
        return new Object[][] {
                {new double[]{3,5,0,16}, 3.0},
                {new double[]{10.7,-5,0,8}, 0.0},
                {new double[]{102,100,35,9}, 100}


        };
    }

    @Test(description = "Positive and negative numbers dataset for FindMaxAmongMin test",
            dataProvider = "dataForTestFindMaxAmongMin")
    public void testFindMaxAmongMin(double[] input, double answer) {
        double result= task27.findMaxAmongMin(input[0],input[1],input[2],input[3] );
        Assert.assertEquals(result, answer);
    }
}