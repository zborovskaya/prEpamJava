package by.zborovskaya.task06.service;

import by.zborovskaya.task06.service.parser.DataParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataParserTest {

    DataParser parser= new DataParser();
    @DataProvider(name="dataForTestCreatePositive")
    public Object[][] createDataForTestPositive() {
        return new Object[][] {
                {"0 2 3 6 2 3 10", new int[]{0,2,3,6,2,3,10}},
                {"3 2 3 6 2 3 6", new int[]{3,2,3,6,2,3,6}},
        };
    }

    @Test(description = "Positive numbers dataset ",
            dataProvider = "dataForTestCreatePositive")
    public void testCreatePositive(String input, int[] answer) {
        int[] result= parser.create(input);
        Assert.assertEquals(result, answer);
    }
}