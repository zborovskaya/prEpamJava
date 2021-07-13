package by.training.task03.service;

import by.training.task03.entity.Array;
import by.training.task03.service.exception.ArrayException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorFillingTest {

    @Test
    public void testCreateFill() {
        //TODO
        try {
            ArrayCreatorFilling arrayCreatorFilling= new ArrayCreatorFilling();
            Array array= arrayCreatorFilling.createFill();
            for (int i=0; i<array.getLength(); i++){
                System.out.println(array.getValue(i));
            }
        }
        catch (ArrayException ex){}


    }
}