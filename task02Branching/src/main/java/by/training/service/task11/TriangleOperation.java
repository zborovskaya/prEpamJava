package by.training.service.task11;


import by.training.entity.Triangle;

public class TriangleOperation {

    /**
     * The function calculate Square
     * @param triangle
     * @return Square
     */
    //TODO убрать static
    public static double calculateSquare(Triangle triangle)
    {
        double a=triangle.getA();
        double b=triangle.getB();
        double c=triangle.getC();
        double p=(a+b+c)/2;
        return (Math.sqrt(p*(p-a)*(p-b)*(p-c)));
    }

}
