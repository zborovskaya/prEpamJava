package by.training.service.task11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import by.training.entity.Triangle;
public class CompareTriangleTest {

    @DataProvider(name="dataForTestCompareSquare")
    public Object[][] createDataForCompareSquare() {
        return new Object[][] {
                {new Triangle[]{new Triangle(3,4,5), new Triangle(3,4,5)},0},
                {new Triangle[]{new Triangle(6,8,10), new Triangle(3,4,5)},1},
                {new Triangle[]{new Triangle(3,4,5), new Triangle(6,8,10)},-1}

        };
    }

    @Test(description = "Positive and negative numbers dataset for CompareSquare test",
            dataProvider = "dataForTestCompareSquare")
    public void testCompareSquare(Triangle[] input, int answer) {

        int result= CompareTriangle.compareSquare(input[0],input[1]);
        Assert.assertEquals(result, answer);


    }
}