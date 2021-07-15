package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalSecond;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadsCreatorSecond {
    static final Logger logger = LogManager.getLogger(ThreadsCreatorSecond.class);
    private DataParser dataParser = new DataParser();
    private ThreadsValidator validator=new ThreadsValidator();
    Semaphore sem = new Semaphore(1);

    /**
     * Function create list of threads
     * @param pathThread
     * @param matrix
     * @return
     */

    public ArrayList<FillingDiagonalSecond> create(String pathThread, SquareMatrix matrix) {
        ArrayList<FillingDiagonalSecond> t = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(pathThread);
            if (validator.isValid(data)) {
                t = new ArrayList<>();
                for (int i = 1; i < data.size(); i++) {
                    int[] param = dataParser.create(data.get(i));
                    t.add(i - 1,new FillingDiagonalSecond(param[0], sem, matrix));
                }
            }
        } catch (Exception ex){
            logger.error("Error in creating thread");
        }
        return t ;
    }
}
