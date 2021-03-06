package by.training.task03.control.command;

import by.training.task03.entity.Array;
import by.training.task03.entity.RepositoryArray;
import by.training.task03.service.ServiceFactory;
import by.training.task03.service.Sorting;
import by.training.task03.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShakerSorting implements Command{
    private static final Logger logger = LogManager.getLogger(ShakerSorting.class);
    public String execute(boolean order) {
        /**
         * The function calls a factory, which gives the necessary Shaker sorting
         * @return 1)Sorting completed successfully
         *         2)Error in performing sorting
         */
        String response = null;
        try {
            RepositoryArray repositoryArray=new RepositoryArray();
            Array array=repositoryArray.getArray();
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            Sorting shakerSort=serviceFactory.getShakerSort();
            shakerSort.sort(array,order);
            repositoryArray.setArray(array);
            repositoryArray.putArrayIntoFile();
            response = "Sorting completed successfully";
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            response = "Error in performing sorting";
        }
        return response;
    }
}
