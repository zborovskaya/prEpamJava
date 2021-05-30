package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task3Test {

    Task3 task3=new Task3();

    @DataProvider(name="dataForTestCompare")
    public Object[][] createDataForTestCompare() {
        return new Object[][] {
                {1, "yes"},
                {4, "no"}

        };
    }
    @Test(description = "Positive and negative numbers dataset for Compare test",
            dataProvider = "dataForTestCompare")
    public void testCompare(double input, String answer) {
        String result= task3.compare(input);
        Assert.assertEquals(result, answer);
    }
}