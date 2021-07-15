package by.zborovskaya.task06.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixDAOImpl implements MatrixDAO{
    static final Logger logger = LogManager.getLogger(MatrixDAOImpl.class);
    /**
     * Function read data from file
     * @param path
     * @return
     */

    @Override
    public List<String> readData(String path) {
        //String PATH="./task06Concurrency/data/dataMatrix.txt"

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error in reading file");
            e.printStackTrace();
        }
        return list;
    }
}
