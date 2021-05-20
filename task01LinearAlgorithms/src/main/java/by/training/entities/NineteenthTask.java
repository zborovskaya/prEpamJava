package by.training.entities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class NineteenthTask {
    static final Logger logger = LogManager.getLogger(NineteenthTask.class.getName());
    private double a;
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
     *The function calculates the value of the square
     * Use the formula for calculations
     * @return square value
     */

    public double getSquare(){
        if (bool) {
            return ((a * a * Math.sqrt(3)) / 4);
        }
        else {
            logger.error("Can't find the square");
            return 0;
        }
    }
    /**
     *The function calculates the value of the height
     * Use the formula for calculations
     * @return height value
     */

    public double getHeight(){
        if (bool) {
            double h = a * Math.sqrt(3) / 2;
            return h;
        }
        else {
            logger.error("Can't find the Height");
            return 0;
        }
    }
    /**
     *The function calculates the value of the the Inscribed circle radius
     * Use the formula for calculations
     * @return the Inscribed circle radius value
     */
    public double getRadiusIn(){
        if (bool) {
            double r = a * Math.sqrt(3) / 6;
            return r;
        }
        else {
            logger.error("Can't find the Inscribed circle radius");
            return 0;
        }
    }
    /**
     *The function calculates the value of the the the circumscribed circle
     * Use the formula for calculations
     * @return the the circumscribed circle
     */
    public double getRadiusOut(){
        if (bool) {
            double r = a * Math.sqrt(3) / 3;
            return r;
        }
        else {
            logger.error(" Can't find the radius of the circumscribed circle");
            return 0;
        }
    }
}
