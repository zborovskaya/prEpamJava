package by.training.service.creator;

import by.training.entity.Triangle;
import by.training.service.exception.TriangleException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleCreatorTest {

    @Test(description = "Positive numbers dataset for testCreate")
    public void testCreatePositiv() throws TriangleException {

            TriangleCreator triangleCreator= new TriangleCreator();
            Triangle triangle= triangleCreator.create(3,4,5);
            Triangle expected= new Triangle(3,4,5);
            assertEquals(triangle, expected);


    }
    @DataProvider(name="dataForTestCreateNegative")
    public Object[][] createDataForCompareSquare() {
        return new Object[][] {
                {new int[]{1,2,3},null},
                {new int[]{-1,-2,3},null},
                {new int[]{0,0,0}, null}

        };
    }

    @Test(description = "Negative numbers dataset for testCreate",
            dataProvider = "dataForTestCreateNegative")
    public void testCreateNegative(int[] input, Triangle expected ) {
        try {
            TriangleCreator triangleCreator= new TriangleCreator();
            Triangle triangle= triangleCreator.create(input[0],input[1],input[2] );
            assertEquals(triangle, expected);
        }
        catch(TriangleException e){}

    }
}