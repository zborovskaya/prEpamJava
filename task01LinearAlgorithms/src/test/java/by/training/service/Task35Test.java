package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task35Test {
    Task35 task35 = new Task35();
    @DataProvider(name="dataForTestCalculate")
    public Object[][] createDataForTestCalculate() {
        return new Object[][]{
                {new int[]{6, 5}, new int[]{1,2}},
                {new int[]{6, 0}, null}


        };
    }
    @Test(description = "Positive and negative numbers dataset for Calculate test",
            dataProvider = "dataForTestCalculate")
    public void testCalculate(int[] input, int[]  answer) {
        task35.setM(input[0]);
        task35.setN(input[1]);
        int [] result= task35.calculate();
        Assert.assertEquals(result, answer);

    }
}