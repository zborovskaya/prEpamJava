package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import org.testng.Assert;

import static org.testng.Assert.*;

public class ConeOperationTest {
    Cone cone= new Cone(3,2,3,6,2,3,10);
    ConeOperation coneOperation= new ConeOperation();
    @org.testng.annotations.Test
    public void testCalculateSquare() {
        double result=coneOperation.calculateSquare(cone);
        double expect=75.398;
        Assert.assertEquals(result, expect,0.01);
    }

    @org.testng.annotations.Test
    public void testCalculateVolume() {
        double result=coneOperation.calculateVolume(cone);
        double expect=37.699;
        Assert.assertEquals(result, expect,0.01);
    }

    @org.testng.annotations.Test
    public void testIsCone() {
        boolean result=coneOperation.isCone(cone);
        boolean expect=true;
        Assert.assertEquals(result, expect);
    }

    @org.testng.annotations.Test
    public void testCalcParallelPlane() {
        String result=coneOperation.calcParallelPlane(cone);
        String expect="XY";
        Assert.assertEquals(result, expect);
    }

    @org.testng.annotations.Test
    public void testCalcRatioVolumes() {
        double result=coneOperation.calcRatioVolumes(cone,9);
        double expect=0.015873;
        Assert.assertEquals(result, expect,0.0001);
    }
}