package by.zborovskaya.task06.service.parser;

public class DataParser {
    /**
     * Function converts the String array in double array
     * @param data - String array
     * @return double array
     */
    public int[] create(String data) {
        String[] parameters = data.trim().split("\\s+");
        int length=parameters.length;
        int[] dataForCreator= new int[length];
        for (int i=0; i<length;i++) {
            dataForCreator[i]=Integer.parseInt(parameters[i]);
        }
        return dataForCreator;
    }
}
