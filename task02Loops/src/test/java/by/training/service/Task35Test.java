package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task35Test {

    Task35 task35=new Task35();
    @DataProvider(name="dataForTestCalculate")
    public Object[][] createDataForTestCalculate() {
        return new Object[][] {
                {13725981, 2},
                {468220, 6},
                {0,-1 },
                {-5, -1},

        };
    }

    @Test(description = "Positive and negative numbers dataset for Calculate test",
            dataProvider = "dataForTestCalculate")
    public void testCalculate(int input, int answer) {

        int result= task35.calculate(input);
        Assert.assertEquals(result, answer);
    }
}