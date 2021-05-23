package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task19Test {
    Task19 task19 = new Task19();
    @DataProvider(name="value1")
    public Object[][] createDataForFunction1() {
        return new Object[][]{
                {4, 6.93},
                {1.5, 0.97},
                {0, 0.0},
                {-5,0.0},
                {-5.4,0.0}

        };
    }
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value1")
    public void testGetSquare(double input, double answer) {
        task19.setA(input);
        double result= task19.getSquare();
        Assert.assertEquals(result, answer, 0.01);
    }

    @DataProvider(name="value2")
    public Object[][] createDataForFunction2() {
        return new Object[][]{
                {4, 3.46},
                {1.5, 1.30},
                {0, 0.0}
        };
    }
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value2")
    public void testGetHeight(double input, double answer) {
        task19.setA(input);
        double result= task19.getHeight();
        Assert.assertEquals(result, answer, 0.01);
    }
    @DataProvider(name="value3")
    public Object[][] createDataForFunction3() {
        return new Object[][]{
                {4, 1.15},
                {1.5,0.43},
                {0, 0.0}
        };
    }
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value3")
    public void testGetRadiusIn(double input, double answer) {
        task19.setA(input);
        double result= task19.getRadiusIn();
        Assert.assertEquals(result, answer, 0.01);
    }
    @DataProvider(name="value4")
    public Object[][] createDataForFunction4() {
        return new Object[][]{
                {4, 2.31},
                {1.5, 0.87},

        };
    }
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value4")
    public void testGetRadiusOut(double input, double answer) {
        task19.setA(input);
        double result= task19.getRadiusOut();
        Assert.assertEquals(result, answer, 0.01);
    }
}