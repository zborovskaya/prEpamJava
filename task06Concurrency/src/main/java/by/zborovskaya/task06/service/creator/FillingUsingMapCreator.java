package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.service.fillingDiagonal.FillingUsingMap;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class FillingUsingMapCreator {
    static final Logger logger = LogManager.getLogger(ThreadsCreatorFirst.class);
    private DataParser dataParser = new DataParser();
    private ThreadsValidator validator=new ThreadsValidator();
    ReentrantLock locker=new ReentrantLock();


    public ArrayList<FillingUsingMap> create(String pathThread, Map<Integer, Integer> map,int matrixSize) {
        ArrayList<FillingUsingMap> t = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(pathThread);
            if (validator.isValid(data)) {
                t = new ArrayList<>();
                for (int i = 1; i < data.size(); i++) {
                    int[] param = dataParser.create(data.get(i));
                    t.add(i - 1,new FillingUsingMap(param[0], map,matrixSize,locker));
                }
            }
        } catch (Exception ex){
            logger.error("Error in creating thread");
        }
        return t ;
    }
}
