package by.zborovskaya.task06.service.validator;

import by.zborovskaya.task06.service.parser.DataParser;

import java.util.List;

public class MatrixValidator {
    private DataParser dataParser = new DataParser();

    /**
     * Function check data
     * If data is valid, function return true
     * If data isn't valid, function return false
     * @param data
     * @return
     */

    public boolean isValid(List<String> data)
    {
        int[] boundary= dataParser.create(data.get(0));
        int numberOfLines = data.size()-1;
        int lengthMatrix=dataParser.create(data.get(1)).length;
        int lengthStr=data.get(1).length();
        for(int i=2; i<numberOfLines+1;i++) {
            if(lengthStr!=data.get(i).length()) return false;
        }
        return ((lengthMatrix>=boundary[0]) && (lengthMatrix<=boundary[1]) && (lengthMatrix==numberOfLines) &&
                (boundary[0]>0) && (boundary[1]>0));
    }
}
