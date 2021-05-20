package by.training.entities;

public class TwentySeventhTask {
    private double a;
    /**
     *The function sets the value of the field a
     * @param value is double value
     */
    public void setA(double value) {
            a = value;
    }

    /**
     * The function calculates the value a^8 and a^10
     * calculate a^2 as a*a
     * calculate a^4 as a^2*a^2
     * calculate a^8 as a^4*a^4
     * calculate a^10 as a^8*a^2
     * @return value a^8 and a^10
     */
    public double[] calculate() {
        double[] result = new double[2];
        double a2 = a * a;
        double a4 = a2 * a2;
        result[0] = a4 * a4;
        result[1] = result[0] * a2;
        return result;
    }
}
