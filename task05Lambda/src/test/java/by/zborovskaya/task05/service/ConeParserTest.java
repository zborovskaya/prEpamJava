package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeParserTest {
    ConeParser coneParser= new ConeParser();
    @DataProvider(name="dataForTestCreatePositive")
    public Object[][] createDataForTestPositive() {
        return new Object[][] {
                {"3.4 2.6 3.7 6.1 2.7 3.3 10.1", new double[]{3.4,2.6,3.7,6.1,2.7,3.3,10.1}},
                {"0 2 3 6 2 3 10", new double[]{0,2,3,6,2,3,10}},
                {"3 2 3 6 2 3 6", new double[]{3,2,3,6,2,3,6}},
        };
    }

    @Test(description = "Positive numbers dataset ",
            dataProvider = "dataForTestCreatePositive")
    public void testCreatePositive(String input, double[] answer) {
        double[] result= coneParser.create(input);
        Assert.assertEquals(result, answer);
    }
}