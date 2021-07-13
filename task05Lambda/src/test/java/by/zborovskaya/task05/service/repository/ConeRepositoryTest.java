package by.zborovskaya.task05.service.repository;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.repository.comparator.*;
import by.zborovskaya.task05.service.repository.specification.CoordinateXSearch;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class ConeRepositoryTest {

    @Test
    public void testAdd() {
        ConeRepository coneRepository=ConeRepository.getInstance(new ArrayList<>());
        List<Cone> coneList=new ArrayList<>();
        coneList.add(new Cone(3,4,3,6,4,3,10));
        coneList.add(new Cone(4,2,3,6,2,3,10));
        coneList.add(new Cone(4,2,2,6,2,2,10));
        coneRepository.add(new Cone(3,4,3,6,4,3,10));
        coneRepository.add(new Cone(4,2,3,6,2,3,10));
        coneRepository.add(new Cone(4,2,2,6,2,2,10));
        Assert.assertEquals(coneRepository.getConeList(), coneList);
    }

    @Test
    public void testSortByPointMCoordinateX() {
        ConeRepository coneRepository=ConeRepository.getInstance(new ArrayList<>());
        coneRepository.add(new Cone(3,4,3,6,4,3,10));
        coneRepository.add(new Cone(4,2,3,6,2,3,10));
        coneRepository.add(new Cone(4,2,2,6,2,2,10));
        List<Cone> coneListSortX=new ArrayList<>();

        coneListSortX.add(0,new Cone(4,2,3,6,2,3,10));
        coneListSortX.add(1,new Cone(4,2,2,6,2,2,10));
        coneListSortX.add(2,new Cone(3,4,3,6,4,3,10));
        coneRepository.sort(new PointMCoordinateXComp());
        Assert.assertEquals(coneRepository.getConeList(), coneListSortX);
    }

    @Test
    public void testFind() {
        ConeRepository coneRepository=ConeRepository.getInstance(new ArrayList<>());
        coneRepository.add(new Cone(3,4,3,6,4,3,10));
        coneRepository.add(new Cone(4,2,3,6,2,3,10));
        coneRepository.add(new Cone(4,2,2,6,2,2,10));
        List<Cone> coneList=new ArrayList<>();
        coneList.add(0,new Cone(4,2,3,6,2,3,10));
        coneList.add(1,new Cone(4,2,2,6,2,2,10));
        List<Cone> result=coneRepository.find(new CoordinateXSearch(2));
        Assert.assertEquals( result, coneList);
    }

    @Test
    public void testUpdate() {
        ConeRepository coneRepository=ConeRepository.getInstance(new ArrayList<>());
        Cone cone = new Cone(3,4,3,6,4,3,10);
        coneRepository.add(cone);
        coneRepository.add(new Cone(4,2,3,6,2,3,10));
        coneRepository.add(new Cone(4,2,2,6,2,2,10));
        cone.update(1,4,3,6,4,3,10);
        coneRepository.update(cone);
        List<Cone> coneList=new ArrayList<>();
        coneList.add(0,new Cone(1,4,3,6,4,3,10));
        coneList.add(1,new Cone(4,2,3,6,2,3,10));
        coneList.add(2,new Cone(4,2,2,6,2,2,10));
        Assert.assertEquals( coneRepository.getConeList(), coneList);
    }

}