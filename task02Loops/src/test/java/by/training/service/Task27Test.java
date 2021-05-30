package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Task27Test {

    Task27 task27= new Task27();

    String output="5 : \n" +
            "6 : 3; 2; \n" +
            "7 : \n" +
            "8 : 4; 2; \n" +
            "9 : 3; \n" +
            "10 : 5; 2; \n" +
            "11 : \n" +
            "12 : 6; 4; 3; 2; \n";


    @DataProvider(name="dataForTestCalculateDivisors")
    public Object[][] createDataForTestCalculateDivisors() {
        return new Object[][] {
                {new int[]{5,12}, output},
                {new int[]{12,5}, ""},
                {new int[]{-4,5}, ""},
                {new int[]{-4,-5}, ""},
                {new int[]{4,-5}, ""}

        };
    }

    @Test(description = "Positive and negative numbers dataset for Calculate test",
            dataProvider = "dataForTestCalculateDivisors")
    public void testCalculateDivisors(int[] input, String answer) {

        String result= task27.calculateDivisors(input[0],input[1]);
        Assert.assertEquals(result, answer);
    }
}