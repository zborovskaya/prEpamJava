package by.training.service;

public class Task19 {

    /**
     * Calculate number of positive
     * @param a
     * @param b
     * @param c
     * @return number of positive
     */
    public int calculate(double a,double b, double c)
    {
        int positiveAmount =0;
        if (a>0) positiveAmount++;
        if (b>0) positiveAmount++;
        if (c>0) positiveAmount++;
        return positiveAmount;
    }
}
