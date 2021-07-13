package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConeValidatorTest {
    ConeValidator coneValidator=new ConeValidator();

    @DataProvider(name="testIsValidPositive")
    public Object[][] createDataForTestPositive() {
        return new Object[][] {
                {"3 2.0 3.6 5.7 4.9 3.4 2.3", true},
                {"0 2.0 3.6 5.7 4.9 3.4 2.3", true},
                {"3 -2.0 3.6 -5.7 4.9 3.4 2.3", true},
                {"3 -2.0 -3.6 -5.7 -4.9 -3.4 -2.3", true}
        };
    }

    @Test(description = "Positive numbers dataset ",
            dataProvider = "testIsValidPositive")
    public void testIsValidPositive(String input, boolean answer) {
        boolean result= coneValidator.isValid(input);
        Assert.assertEquals(result, answer);
    }
    @DataProvider(name="testIsValidNegative")
    public Object[][] createDataForTestNegative() {
        return new Object[][] {
                {"3 2.0 3.6 5.7", false},
                {"-5 2.0 3.6 5.7 4.9 3.4 2.3", false},
                {"1 2 cd3 4 5 6 7", false},
        };
    }

    @Test(description = "Negative numbers dataset ",
            dataProvider = "testIsValidNegative")
    public void testIsValidNegative(String input, boolean answer) {
        boolean result= coneValidator.isValid(input);
        Assert.assertEquals(result, answer);
    }

}