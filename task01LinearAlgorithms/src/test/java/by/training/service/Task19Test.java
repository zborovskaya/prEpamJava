package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task19Test {
    Task19 task19 = new Task19();
    @DataProvider(name="dataGetSquare")
    public Object[][] createDataGetSquare() {
        return new Object[][]{
                {4, 6.93},
                {1.5, 0.97},
                {0, 0.0},
                {-5,0.0},
                {-5.4,0.0}

        };
    }
    @Test(description = "Positive and negative numbers dataset for GetSquare test",
            dataProvider = "dataGetSquare")
    public void testGetSquare(double input, double answer) {
        task19.setA(input);
        double result= task19.getSquare();
        Assert.assertEquals(result, answer, 0.01);
    }

    @DataProvider(name="dataForTestGetHeight")
    public Object[][] createDataForTestGetHeight() {
        return new Object[][]{
                {4, 3.46},
                {1.5, 1.30},
                {0, 0.0},
                {-5,0.0},
                {-5.4,0.0}
        };
    }
    @Test(description = "Positive and negative numbers dataset for GetHeight test",
            dataProvider = "dataForTestGetHeight")
    public void testGetHeight(double input, double answer) {
        task19.setA(input);
        double result= task19.getHeight();
        Assert.assertEquals(result, answer, 0.01);
    }
    @DataProvider(name="dataForTestGetRadiusIn")
    public Object[][] createDataForTestGetRadiusIn() {
        return new Object[][]{
                {4, 1.15},
                {1.5,0.43},
                {0, 0.0},
                {-5,0.0},
                {-5.4,0.0}
        };
    }
    @Test(description = "Positive and negative numbers dataset for GetRadiusIn test",
            dataProvider = "dataForTestGetRadiusIn")
    public void testGetRadiusIn(double input, double answer) {
        task19.setA(input);
        double result= task19.getRadiusIn();
        Assert.assertEquals(result, answer, 0.01);
    }
    @DataProvider(name="dataForTestGetRadiusOut")
    public Object[][] createDataForTestGetRadiusOut() {
        return new Object[][]{
                {4, 2.31},
                {1.5, 0.87},
                {0, 0.0},
                {-5,0.0},
                {-5.4,0.0}

        };
    }
    @Test(description = "Positive and negative numbers dataset for GetRadiusOut test",
            dataProvider = "dataForTestGetRadiusOut")
    public void testGetRadiusOut(double input, double answer) {
        task19.setA(input);
        double result= task19.getRadiusOut();
        Assert.assertEquals(result, answer, 0.01);
    }
}