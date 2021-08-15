package by.zborovskaya.task07.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextDAOImpl implements TextDAO{
    static final Logger logger = LogManager.getLogger(TextDAOImpl.class);
    /**
     * Function read data from file
     * @param path
     * @return String value
     */

    @Override
    public String readData(String path) {

        String txt = null;
        try {
            txt = Files.lines(Paths.get(path))
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            logger.error("Error in reading file");
            e.printStackTrace();
        }
        return txt;
    }

}
