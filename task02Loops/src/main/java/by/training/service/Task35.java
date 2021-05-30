package by.training.service;

public class Task35 {

    /**
     * Finds the number of even digits of a number
     * @param m
     * @return count
     */

    public int calculate(int m) {
        if (m>0) {
            int count = 0;
            while (m > 0) {
                if ((m % 10) % 2 == 0)
                    count++;
                m /= 10;
            }
            return count;
        }
        else return -1;
    }
}
