package by.training.service;

public class Task19 {

    /**
     * Given a number series and some number e.
     * Find the sum of those terms of the series whose modulus is greater than e
     * @param e
     * @return sum
     *         1,5 if e<=0
     */
    public double calculate(double e){

        double a=(double)1/2+(double)1/3;
        double sum=0;
        int n=1;
        if(e>0) {
            while (a >= e) {
                sum = sum + a;
                n++;
                a = 1 / (Math.pow(2, n)) + 1 / (Math.pow(3, n));
            }
            return sum;
        }
        else return 1.5;
    }
}
