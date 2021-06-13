package by.training.entity;

/**
 * Claass contains fields - sides of a triangle
 */

public class Triangle {

    private  double a;
    private  double b;
    private  double c;

    public Triangle(double a,double b,double c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle)o;
       if( triangle.getA()!=a || triangle.getB()!=b || triangle.getC()!=c) {return false;}
       return true;
    }
}
