package by.zborovskaya.task05.service;

public class ConeValidator {
    private final String R_TWO_POINTS_AND_ID_REGEX= "(0|([1-9][0-9]*))(\\.[0-9]+)?\\s" +
            "((-?)(0|([1-9][0-9]*))(\\.[0-9]+)?\\s){5}" +
            "(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?";

    /**
     * checks the validity of the string
     * @param data
     * @return
     */
    public boolean isValid(String data) {
        return data.matches(R_TWO_POINTS_AND_ID_REGEX);
    }
}