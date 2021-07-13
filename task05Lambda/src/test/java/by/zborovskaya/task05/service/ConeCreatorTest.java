package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeCreatorTest {
    ConeCreator coneCreator=new ConeCreator();
    @DataProvider(name="dataForTestCreatePositive")
    public Object[][] createDataForTestPositive() {
        return new Object[][] {
                {new double[]{3,2,3,6,2,3,10}, new Cone(3,2,3,6,2,3,10)},
                {new double[]{0,2,3,6,2,3,10}, new Cone(0,2,3,6,2,3,10)},
                {new double[]{3,2,3,6,2,3,6}, new Cone(3,2,3,6,2,3,6)},
        };
    }

    @Test(description = "Positive numbers dataset ",
            dataProvider = "dataForTestCreatePositive")
    public void testCreatePositive(double[] input, Cone answer) {
        Cone result= coneCreator.create(input[0],input[1],input[2],input[3],input[4],
                input[5],input[6]);
        Assert.assertEquals(result, answer);
    }
    @DataProvider(name="dataForTestCreateNegative")
    public Object[][] createDataForTestNegative() {
        return new Object[][]{
                {new double[]{3, 2, 3, 6, 2, 4, 10}, null}
        };
    }
    @Test(description = "Negative numbers dataset ",
            dataProvider = "dataForTestCreateNegative")
    public void testCreateNegative(double[] input, Cone answer) {
        Cone result= coneCreator.create(input[0],input[1],input[2],input[3],input[4],
                input[5],input[6]);
        Assert.assertEquals(result, answer);
    }
}