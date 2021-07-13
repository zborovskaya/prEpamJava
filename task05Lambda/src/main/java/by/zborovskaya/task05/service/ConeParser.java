package by.zborovskaya.task05.service;

public class ConeParser {
    /**
     * Function converts the String array in double array
     * @param data - String array
     * @return double array
     */
    public double[] create(String data) {
        String[] parameters = data.trim().split("\\s+");
        int length=parameters.length;
        double[] dataForCreator= new double[length];
        for (int i=0; i<length;i++) {
            dataForCreator[i]=Double.parseDouble(parameters[i]);
        }
       return dataForCreator;
    }
}
