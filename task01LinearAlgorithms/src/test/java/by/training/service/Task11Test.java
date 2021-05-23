package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task11Test {

    Task11 task11 =new Task11();
    @DataProvider(name="value1")
    public Object[][] createDataForFunction1() {
        return new Object[][] {
                {new double[]{3,5}, 13.83},
                {new double[]{3.6, 7}, 18.47},
                {new double[]{0, 0}, 0.0},
                {new double[]{-5, -6}, 0.0},
                {new double[]{-5, 6}, 0.0},
                {new double[]{5, -6}, 0.0}
        };
    }

    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value1")
    public void testGetPerimeter(double[] input, double answer) {
        task11.setA(input[0]);
        task11.setB(input[1]);
        double result= task11.getPerimeter();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer);
        Assert.assertEquals(result, answer, 0.01);
    }
@DataProvider(name="value2")
public Object[][] createDataForFunction2() {
    return new Object[][] {
            {new double[]{3,5}, 7.5},
            {new double[]{3.6, 7}, 12.6},
            {new double[]{0, 0}, 0.0},
            {new double[]{-5, -6}, 0.0},
            {new double[]{-5, 6}, 0.0},
            {new double[]{5, -6}, 0.0}
    };
}
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value2")
    public void testGetSquare(double[] input, double answer) {
        task11.setA(input[0]);
        task11.setB(input[1]);
        double result= task11.getSquare();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer);
        Assert.assertEquals(result, answer, 0.01);
    }
}