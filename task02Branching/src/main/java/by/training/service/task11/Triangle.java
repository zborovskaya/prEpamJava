package by.training.service.task11;

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

    /**
     * Function calculate Square
     * @return Square
     */
    public double calculateSquare()
    {
        double p=(a+b+c)/2;
        return (Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

}
