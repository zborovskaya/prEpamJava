package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.ThreadsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DataCreatorThird {
    static final Logger logger = LogManager.getLogger(DataCreatorThird.class);
    private DataParser dataParser = new DataParser();
    private ThreadsValidator validator=new ThreadsValidator();
    Semaphore sem = new Semaphore(1);

    /**
     * Function creates data for thread's fields
     * @param pathThread
     * @param matrix
     * @return
     */

    public ArrayList<Integer> create(String pathThread, SquareMatrix matrix) {

        ArrayList<Integer> arr = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(pathThread);
            if (validator.isValid(data)) {
                arr = new ArrayList<>();

                for (int i = 1; i < data.size(); i++) {
                    int[] param = dataParser.create(data.get(i));
                    arr.add(i - 1,param[0]);
                }
            }
        } catch (Exception ex){
            logger.error("Error in creating thread");
        }
        return arr ;
    }

}
