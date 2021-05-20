package by.training.entities;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EleventhTaskTest {

    EleventhTask eleventhTask=new EleventhTask();
    @DataProvider(name="value1")
    public Object[][] createDataForFunction1() {
        return new Object[][] {
                {new double[]{3,5}, 13.83},
                {new double[]{3.6, 7}, 18.47},


        };
    }

    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value1")
    public void testGetPerimeter(double[] input, double answer) {
        eleventhTask.setA(input[0]);
        eleventhTask.setB(input[1]);
        double result=eleventhTask.getPerimeter();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer);
        Assert.assertEquals(result, answer, 0.01);
    }
@DataProvider(name="value2")
public Object[][] createDataForFunction2() {
    return new Object[][] {
            {new double[]{3,5}, 7.5},
            {new double[]{3.6, 7}, 12.6},

    };
}
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value2")
    public void testGetSquare(double[] input, double answer) {
        eleventhTask.setA(input[0]);
        eleventhTask.setB(input[1]);
        double result=eleventhTask.getSquare();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer);
        Assert.assertEquals(result, answer, 0.01);
    }
}