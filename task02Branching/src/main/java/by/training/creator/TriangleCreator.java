package by.training.creator;

import by.training.service.task11.Triangle;
import by.training.exception.TriangleException;
public class TriangleCreator {

    /**
     * Create triangle
     * @param a
     * @param b
     * @param c
     * @return
     * @throws TriangleException
     */

    public Triangle create(double a, double b, double c) throws TriangleException
    {
        Triangle triangle = null;

            if (isValid(a, b, c)) {
                triangle = new Triangle(a, b, c);
            } else throw new TriangleException("The sides of the triangle are entered incorrectly");

            return triangle;
    }

    /**
     * Check data
     * @param a
     * @param b
     * @param c
     * @return true or false
     */


    private boolean isValid(double a, double b, double c)
    {
        return (a>0.0 && b>0.0 && c>0.0 && (a+b)>c && (a+c)>b && (b+c)>a);
    }
}
