package by.zborovskaya.task06.service.validator;

import by.zborovskaya.task06.service.parser.DataParser;

import java.util.List;

public class ThreadsValidator {
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
        return ((numberOfLines>=boundary[0]) && (numberOfLines<=boundary[1]) && (boundary[0]>0) && (boundary[1]>0));
    }
}
