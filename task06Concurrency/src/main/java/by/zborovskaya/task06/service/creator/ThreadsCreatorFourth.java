package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalPhaser;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsCreatorFourth {
    static  final Logger logger = LogManager.getLogger(ThreadsCreatorSecond.class);
    private DataParser dataParser = new DataParser();
    private ThreadsValidator validator=new ThreadsValidator();
    ReentrantLock locker = new ReentrantLock(); // создаем заглушку

    /**
     * Function create list of threads
     * @param pathThread
     * @param matrix
     * @return
     */

    public ArrayList<FillingDiagonalPhaser> create(String pathThread, SquareMatrix matrix) {
        ArrayList<FillingDiagonalPhaser> t = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(pathThread);
            if (validator.isValid(data)) {
                t = new ArrayList<>();
                int numberThreads=data.size()-1;
                Phaser phaser = new Phaser(numberThreads);
                for (int i = 1; i < numberThreads+1; i++) {
                    int[] param = dataParser.create(data.get(i));
                    t.add(i - 1,new FillingDiagonalPhaser(param[0],locker, matrix,phaser,
                            (matrix.getSize()/(numberThreads))+1));
                }
            }
        } catch (Exception ex){
            logger.error("Error in creating thread");
        }
        return t ;
    }
}
