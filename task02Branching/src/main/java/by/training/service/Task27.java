package by.training.service;

public class Task27 {

    /**
     * Find max{min(a, b), min(c, d)}
     * @param a
     * @param b
     * @param c
     * @param d
     * @return max{min(a, b), min(c, d)}
     */

   public double findMaxAmongMin(double a,double b,double c, double d)
   {
       double min1 = a<b? a : b;
       double min2= c<d? c : d;
       return (min1>min2? min1 : min2);
   }
}
