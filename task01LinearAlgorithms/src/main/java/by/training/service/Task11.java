package by.training.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Task11 {
    static final Logger logger = LogManager.getLogger(Task11.class.getName());
    private double a;
    private double b;
    private boolean boolA;
    private boolean boolB;

    /**
     *The function sets the value of the field a
     * @param value is double value
     */
    public void setA(double value) {
        if(value > 0) {
            a = value;
            this.boolA=true;
        } else {
            this.boolA=false;
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
            this.boolB=true;
        } else {
            this.boolB=false;
            logger.error("Negative leg b!");
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
    public double calculatePerimeter() {
        if (this.boolA && this.boolB) {
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
        if (this.boolA && this.boolB) {
            return (a*b/2);
        }
        else {
            logger.error("Can't find the square");
            return 0;
        }

    }

}
