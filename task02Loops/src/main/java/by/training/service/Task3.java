package by.training.service;

public class Task3 {

    /**
     * @return Multiplication table 3
     */


    public String printTable(){
        String table="Multiplication table 3:\n";
        for(int i=1;i<11;i++)
        {
            table= table + "3 * " + i + " = " + (3*i) + "\n";
        }
        return table;
    }

}
