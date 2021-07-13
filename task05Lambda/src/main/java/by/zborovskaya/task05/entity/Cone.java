package by.zborovskaya.task05.entity;


import by.zborovskaya.task05.service.registrar.ConeRegistrar;

import java.util.Objects;

public class Cone {
    ConeRegistrar registrar=ConeRegistrar.getInstance();
    private final int id;
    private static int counter=1;
    private String name;
    private double r;
    private double height;
    private PointCone pointM; //pointM - center of the base of the cone
    private PointCone pointK; //MK - cone height, height perpendicular to the base

    public Cone(double r, double xM, double yM, double zM, double xK, double yK, double zK){
        id = counter++;
        name="Cone"+id;
        this.r = r;
        pointM = new PointCone(xM,yM,zM);
        pointK = new PointCone(xK,yK,zK);
        height=Math.abs((pointK.x-pointM.x)+(pointK.y-pointM.y)+(pointK.z-pointM.z));
        registrar.addCone(this);
    }

    public ConeRegistrar getRegistrar() {
        return registrar;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getR() {
        return r;
    }

    public PointCone getPointM() {
        return pointM;
    }

    public PointCone getPointK() {
        return pointK;
    }

    public double getHeight() {
        return height;
    }

    //PointCone - inner class
    public class PointCone {
        private double x;
        private double y;
        private double z;

        PointCone(double x, double y, double z){
            this.x = x;
            this.y=y;
            this.z=z;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void setZ(double z) {
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PointCone)) return false;
            PointCone pointCone = (PointCone) o;
            return Double.compare(pointCone.getX(), getX()) == 0 &&
                    Double.compare(pointCone.getY(), getY()) == 0 &&
                    Double.compare(pointCone.getZ(), getZ()) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getZ());
        }

        @Override
         public String toString() {
             return "{" +
                     "x=" + x +
                     ", y=" + y +
                     ", z=" + z +
                     '}';
         }
     }
     //end of inner class

    public void update(double r, double xM, double yM, double zM, double xK, double yK, double zK){
        this.r = r;
        pointM.setX(xM);
        pointM.setY(yM);
        pointM.setZ(zM);
        pointK.setX(xK);
        pointK.setY(yK);
        pointK.setZ(zK);
        height=Math.abs((pointK.x-pointM.x)+(pointK.y-pointM.y)+(pointK.z-pointM.z));
        notifyRegistar();
    }
    public void notifyRegistar(){
        registrar.update(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cone)) return false;
        Cone cone = (Cone) o;
        return /*getId() == cone.getId() &&*/
                Double.compare(cone.getR(), getR()) == 0 &&
                /*Objects.equals(getName(), cone.getName()) &&*/
                Objects.equals(getPointM(), cone.getPointM()) &&
                Objects.equals(getPointK(), cone.getPointK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getR(), getPointM(), getPointK());
    }

    @Override
    public String toString() {
        return "Cone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", r=" + r +
                ", pointM=" + pointM.toString() +
                ", pointK=" + pointK.toString() +
                '}';
    }
}
