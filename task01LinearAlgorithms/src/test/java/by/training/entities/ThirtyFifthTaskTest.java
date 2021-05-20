package by.training.entities;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ThirtyFifthTaskTest {
    ThirtyFifthTask thirtyFifthTask= new ThirtyFifthTask();
    @DataProvider(name="value")
    public Object[][] createDataForFunction() {
        return new Object[][]{
                {new int[]{6, 5}, new int[]{1,2}}


        };
    }
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value")
    public void testCalculate(int[] input, int[]  answer) {
        thirtyFifthTask.setM(input[0]);
        thirtyFifthTask.setN(input[1]);
        int [] result=thirtyFifthTask.calculate();
        System.out.println(input[0]+":"+input[1]);
        System.out.println(answer[0]+":"+answer[1]);
        Assert.assertEquals(result, answer);

    }
}