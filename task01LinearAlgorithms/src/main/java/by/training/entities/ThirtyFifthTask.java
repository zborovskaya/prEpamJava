package by.training.entities;

public class ThirtyFifthTask {
    private int m;
    private int n;
    /**
     *The function sets the value of the field m
     * @param m is double value
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     *The function sets the value of the field n
     * @param n is double value
     */
    public void setN(int n) {
        this.n = n;
    }
    /**
     * The function calculates the most significant digit of the fractional part and
     * the least significant digit of the integer part of the number M / N.
     * First, find the result of the division.
     * Find the remainder of dividing the result by 10.
     * It is the least significant digit of the integer part.
     * Multiply the result by 10 and find the remainder of 10.
     * It is the most significant digit of the fractional part.
     * @return an array of calculated results
     */

    public int[] calculate() {
        int[] output = new int[2];
        double result= (double) m / n;
        System.out.println(m + " / " + n + " = " + result);
        output[0] = (int) (result % 10);
        output[1] = (int) ((result * 10) % 10);
        return output;
    }
}