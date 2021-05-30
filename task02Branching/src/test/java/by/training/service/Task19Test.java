package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task19Test {

    Task19 task19=new Task19();

    @DataProvider(name="dataForTestCalculate")
    public Object[][] createDataForTestCalculate() {
        return new Object[][] {
                {new double[]{-3,-5,0}, 0},
                {new double[]{1,-5,0}, 1},
                {new double[]{3,5,0}, 2},
                {new double[]{7,3.5,2}, 3},


        };
    }

    @Test(description = "Positive and negative numbers dataset for Calculate test",
            dataProvider = "dataForTestCalculate")
    public void testCalculate(double[] input, int answer) {

        int result= task19.calculate(input[0],input[1],input[2] );
        Assert.assertEquals(result, answer);
    }

}