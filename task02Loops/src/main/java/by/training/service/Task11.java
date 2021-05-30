package by.training.service;

public class Task11 {

    /**
     * Find difference of cubes of the first two hundred numbers
     * @return difference
     */


    public int calculate(){
        int difference=0;
        for(int i=1;i<201;i++)
        {
            difference=difference-i*i*i;
        }
        return difference;
    }
}
