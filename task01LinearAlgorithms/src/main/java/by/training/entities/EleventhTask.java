package by.training.entities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class EleventhTask {
    static final Logger logger = LogManager.getLogger(EleventhTask.class.getName());
    private double a;
    private double b;
    private boolean bool=true;

    /**
     *The function sets the value of the field a
     * @param value is double value
     */
    public void setA(double value) {
        if(value > 0) {
            a = value;
        } else {
            bool=false;
            logger.error("Negative leg a!");
        }
    }
    /**
     *The function sets the value of the field b
     * @param value is double value
     */
    public void setB(double value) {
        if(value > 0) {
            b = value;
        } else {
            logger.error("Negative leg a!");
        }
    }

    /**
     *The function calculates the value of the perimeter
     * First, find the hypotenuse.
     * The hypotenuse is the sum of the squares of the legs.
     * The perimeter is the sum of the sides of the triangle.
     * Find the perimeter.
     * @return perimeter value
     */
    public double getPerimeter() {
        if (bool) {
            return (Math.sqrt(a * a + b * b) + a + b);
        }
        else {
            logger.error("Can't find the perimeter");
            return 0;
        }
    }
    /**
     * *The function calculates the value of square
     * Using the formula for calculating square
     * @return square value
     */
    public double getSquare(){
        if (bool) {
            return (a*b/2);
        }
        else {
            logger.error("Can't find the square");
            return 0;
        }

    }

}
