package by.zborovskaya.task06.service.creator;

import by.zborovskaya.task06.dao.DAOFactory;
import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.parser.DataParser;
import by.zborovskaya.task06.service.validator.MatrixValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MatrixCreatorFilling {
    static final Logger logger = LogManager.getLogger(MatrixCreatorFilling.class);
    private DataParser dataParser = new DataParser();
    private MatrixValidator validator=new MatrixValidator();

    /**
     * Function create Square Matrix, if data is valid.
     * @param path
     * @return
     */

    public SquareMatrix create(String path) {
        SquareMatrix matrix = null;
        try {
            List<String> data = DAOFactory.getInstance().getMatrixDAOImpl().readData(path);
            if (validator.isValid(data)) {
                matrix = new SquareMatrix(data.size() - 1);
                for (int i = 1; i < data.size(); i++) {
                    int[] param = dataParser.create(data.get(i));
                    for (int j = 0; j < param.length; j++) {
                        matrix.setElement(i - 1, j, param[j]);
                    }
                }
            }
        }catch (Exception ex){
            logger.error("Error in creating matrix");
        }
        return matrix;
        }
}
