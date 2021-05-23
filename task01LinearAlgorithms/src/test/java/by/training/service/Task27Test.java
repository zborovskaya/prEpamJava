package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task27Test {
Task27 task27 = new Task27();
@DataProvider(name="value")
public Object[][] createDataForFunction() {
    return new Object[][] {
            {2,new double[]{256.0,1024.0}},
            {0,new double[]{0.0,0.0}},
            {2.5,new double[]{1525.88,9536.74}},
            {-2.5,new double[]{1525.88,9536.74}}

    };
}
    @Test(description = "Positive and negative numbers dataset for function test",
            dataProvider = "value")
    public void testCalculate(double input, double[]  answer) {
        task27.setA(input);
        double[] result= task27.calculate();
        System.out.println(input);
        System.out.println(answer[0]+":"+answer[1]);
        Assert.assertEquals(result, answer, 0.01);
    }
}