package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task3Test {
    Task3 task3 = new Task3();
    @DataProvider(name="dataForTestCalculate")
    public Object[][] createDataForTestCalculate() {
        return new Object[][] {
                {new double[]{0, 0}, -10.0},
                {new double[]{1.5, 2.8}, 6.99},
                {new double[]{-4, 6.5}, 14.5},
                {new double[]{-4, -6.5}, -50.5},

        };
    }

    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "dataForTestCalculate")
    public void testCalculate(double[] input, double answer) {
        task3.setX(input[0]);
        task3.setY(input[1]);
        double result= task3.calculate();
        Assert.assertEquals(result, answer, 0.01);
    }
}