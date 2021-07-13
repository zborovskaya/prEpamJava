package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.exception.InputException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ConeListCreatorTest {
    ConeListCreator coneListCreator=new ConeListCreator();

    @Test
    public void testCreateList() throws InputException {
        List<Cone>  expected = new ArrayList<Cone>();
        expected.add(0,new Cone(3, 2.0, 3.6, 5.7, 2.0, 3.6, 8.3));
        expected.add(1,new Cone(3, -2.0, -3.6, -5.7, -2.0, -3.6, -8.3));
        expected.add(2,new Cone(0, 3, 2, 6, 3, 2, 10));
        List<Cone> result=coneListCreator.createList("./data/dataCone.txt");
        Assert.assertEquals(result, expected);
    }
}