package by.zborovskaya.task05.dao;

import by.zborovskaya.task05.dao.exception.DAOException;
import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.repository.ConeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConeDAOImpl implements ConeDAO {
    static final Logger logger = LogManager.getLogger(ConeRepository.class);
    // path = "./task05Lambda/data/dataCone.txt"

    /**
     * Function read data from file
     * @param path
     * @return
     */
    @Override
    public List<String> readData(String path) {

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Error in reading file");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void writeData(String path, Cone cone) {
    }

    @Override
    public void clearData(String path) {
    }
}
