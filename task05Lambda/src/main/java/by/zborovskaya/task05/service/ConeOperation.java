package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;

public class ConeOperation {
    /**
     * Method calculate Square
     *S= baseSquare + lateralSurfaceSquare
     * @param cone
     * @return Square
     */
    public  double calculateSquare(Cone cone)
    {
        double h= cone.getHeight();
        double r=cone.getR();
        return(r*Math.PI*(Math.sqrt(r*r+h*h)+r));
    }

    /**
     * Method calculate Volume
     * @param cone
     * @return volume
     */

    public  double calculateVolume(Cone cone)
    {
        double h= cone.getHeight();
        double r=cone.getR();
        return ((Math.PI*h*r*r)/3);
    }

    /**
     * The method checks the object. If shape is cone, return true
     * @param cone
     * @return If shape is cone, return true
     *         If shape isn't cone, return false
     */

    public boolean isCone(Cone cone){
        double h= cone.getHeight();
        double r=cone.getR();
        return ((h>0) && (r>0));
    }

    /**
     * The method checks which coordinate plane is parallel to the base of the cone
     * @param cone
     * @return YZ
     *         XZ
     *         XY
     */

    public String calcParallelPlane(Cone cone){
        String plane=null;
        Cone.PointCone pointM= cone.getPointM();
        Cone.PointCone pointK= cone.getPointK();
        if((pointM.getX()-pointK.getX())!=0) plane="YZ";
        if((pointM.getY()-pointK.getY())!=0) plane="XZ";
        if((pointM.getZ()-pointK.getZ())!=0) plane="XY";
        return plane;
    }

    /**
     *The function considers the ratios of the volumes obtained
     *  as a result of cutting the figure by the coordinate plane
     * @param cone
     * @param planeEquation
     * @return V1/V2; V2 - conoid, V1- result cone; V=V1+V2
     */

    public double calcRatioVolumes(Cone cone, double planeEquation){
        double result=0;
        String plane=calcParallelPlane(cone);
        Cone.PointCone pointM= cone.getPointM();
        Cone.PointCone pointK= cone.getPointK();
        double h=cone.getHeight();
        if(plane.equals("XY")){
            double zM= pointM.getZ();
            double zK= pointK.getZ();
            // Проверяем, пересекает ли плоскость заданный конус
            if (((zK>zM) && (zK>planeEquation) && (planeEquation>zM) )||
                    ((zM>zK) && (zM>planeEquation) && (planeEquation>zK)))
            {
//                System.out.println("XY");
                double h1= Math.abs(zK-planeEquation);
                result=((h1*h1*h1)/(h*h*h-h1*h1*h1));
            }
        }
        if(plane.equals("YZ")){
            double xM= pointM.getX();
            double xK= pointK.getX();
            // Проверяем, пересекает ли плоскость заданный конус
            if (((xK>xM) && (xK>planeEquation) && (planeEquation>xM) )||
                    ((xM>xK) && (xM>planeEquation) && (planeEquation>xK)))
            {
//                System.out.println("YZ");
                double h1=Math.abs(xK-planeEquation);
                result=((h1*h1*h1)/(h*h*h-h1*h1*h1));
            }
        }
        if(plane.equals("XZ")){
            double yM= pointM.getY();
            double yK= pointK.getY();
            // Проверяем, пересекает ли плоскость заданный конус
            if (((yK>yM) && (yK>planeEquation) && (planeEquation>yM) )||
                    ((yM>yK) && (yM>planeEquation) && (planeEquation>yK)))
            {
//                System.out.println("XZ");
                double h1=Math.abs(yK-planeEquation);
                result=((h1*h1*h1)/(h*h*h-h1*h1*h1));
            }
        }
        return result;
    }
}
