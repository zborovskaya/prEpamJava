package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalFirst;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsCreatorFirst {
    static final Logger logger = LogManager.getLogger(ThreadsCreatorFirst.class);
    private DataParser dataParser = new DataParser();
    private ThreadsValidator validator=new ThreadsValidator();
    ReentrantLock locker = new ReentrantLock(); // создаем заглушку

    /**
     * Function create list of threads
     * @param pathThread
     * @param matrix
     * @return
     */

    public ArrayList<FillingDiagonalFirst> create(String pathThread, SquareMatrix matrix) {
        ArrayList<FillingDiagonalFirst> t = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(pathThread);
            if (validator.isValid(data)) {
                t = new ArrayList<>();
                for (int i = 1; i < data.size(); i++) {
                    int[] param = dataParser.create(data.get(i));
                    t.add(i - 1,new FillingDiagonalFirst(param[0], locker, matrix));
                }
            }
        } catch (Exception ex){
            logger.error("Error in creating thread");
        }
        return t ;
    }
}
