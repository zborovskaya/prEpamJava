package by.training.service;

public class Task27 {


    /**
     * For each natural number in the range from m to n, output all divisors except one and
     * the number itself. m and n are entered from the keyboard.
     * @param m
     * @param n
     * @return divisors
     */

    public String calculateDivisors(int m,int n)
    {
        String divisors="";
        if(m>0 && n>0 && n>m) {
            while (m <= n) {
                divisors =divisors+ m + " : ";
                for (int i = m - 1; i > 1; i--) {
                    if (m % i == 0) divisors =divisors+ i + "; ";
                }
                divisors =divisors+ "\n";
                m++;
            }
        }
        return divisors;
    }
}
