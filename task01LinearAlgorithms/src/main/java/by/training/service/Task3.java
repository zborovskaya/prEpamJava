package by.training.service;

public class Task3 {

    private double x;
    private double y;

    /**
     *The function sets the value of the field x
     * @param x is double value
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     *The function sets the value of the field y
     * @param y is double value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * The function {@link Task3#calculate} finds the value of an expression z=2*x+(y-2)*5    z(x,y)=a*x+(y-b)*c
     * @return double value that is calculation result
     */

    public double calculate() {
        return (2*x+(y-2)*5);
    }
}
