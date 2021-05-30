package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task19Test {

    Task19 task19=new Task19();

    @DataProvider(name="dataForTestCalculate")
    public Object[][] createDataForTestCalculate() {
        return new Object[][] {
                {1, 0.0},
                {0.5, 0.83333},
                {0.162, 1.35648},
                {0.0, 1.5},
                {-5, 1.5},

        };
    }

    @Test(description = "Positive and negative numbers dataset for Calculate test",
            dataProvider = "dataForTestCalculate")
    public void testCalculate(double input, double answer) {

        double result= task19.calculate(input);
        Assert.assertEquals(result, answer, 0.0001);
    }
}