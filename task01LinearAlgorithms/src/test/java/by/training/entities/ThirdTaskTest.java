package by.training.entities;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThirdTaskTest {
    ThirdTask thirdTask= new ThirdTask();
    @DataProvider(name="value")
    public Object[][] createDataForFunction() {
        return new Object[][] {
                {new double[]{0, 0}, -10.0},
                {new double[]{1.5, 2.8}, 6.99},
                {new double[]{-4, 6.5}, 14.5},
                {new double[]{-4, -6.5}, -50.5},

        };
    }

    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value")
    public void testCalculate(double[] input, double answer) {
        thirdTask.setX(input[0]);
        thirdTask.setY(input[1]);
        double result=thirdTask.calculate();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer);
        Assert.assertEquals(result, answer, 0.01);
    }
}