package by.training.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task11Test {
    int answer=-404010000;
    Task11 task11= new Task11();


    @Test
    public void testCalculate() {
        double result= task11.calculate();
        Assert.assertEquals(result, answer);
    }
}