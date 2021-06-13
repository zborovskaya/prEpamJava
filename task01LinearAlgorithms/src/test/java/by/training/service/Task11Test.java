package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task11Test {

    Task11 task11 =new Task11();
    @DataProvider(name="dataForTestGetPerimeter")
    public Object[][] createDataForTestGetPerimeter() {
        return new Object[][] {
                {new double[]{3,5}, 13.83},
                {new double[]{3.6, 7}, 18.47},
                {new double[]{0, 0}, 0.0},
                {new double[]{-5, -6}, 0.0},
                {new double[]{-5, 6}, 0.0},
                {new double[]{5, -6}, 0.0}

        };
    }


    @Test(description = "Positive and negative numbers dataset for GetPerimeter test",
            dataProvider = "dataForTestGetPerimeter")
    public void testGetPerimeter(double[] input, double answer) {
        task11.setA(input[0]);
        task11.setB(input[1]);
        double result= task11.calculatePerimeter();
        Assert.assertEquals(result, answer, 0.01);
    }

@DataProvider(name="dataForTestGetSquare")
public Object[][] createDataForTestGetSquare() {
    return new Object[][] {
            {new double[]{3,5}, 7.5},
            {new double[]{3.6, 7}, 12.6},
            {new double[]{0, 0}, 0.0},
            {new double[]{-5, -6}, 0.0},
            {new double[]{-5, 6}, 0.0},
            {new double[]{5, -6}, 0.0}
    };
}
    @Test(description = "Positive and negative numbers dataset for GetSquare test",
            dataProvider = "dataForTestGetSquare")
    public void testGetSquare(double[] input, double answer) {
        task11.setA(input[0]);
        task11.setB(input[1]);
        double result= task11.getSquare();
        Assert.assertEquals(result, answer, 0.01);
    }
}