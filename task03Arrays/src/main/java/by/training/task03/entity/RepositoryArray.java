package by.training.task03.entity;

import by.training.task03.dao.ArrayDAO;
import by.training.task03.dao.DAOFactory;
import by.training.task03.service.ArrayCreatorFilling;
import by.training.task03.service.exception.ArrayException;
import by.training.task03.service.exception.ServiceException;

public class RepositoryArray {

    Array repositoryArr ;

    public RepositoryArray() throws ServiceException{
        try {
            ArrayCreatorFilling arrayCreatorFilling= new ArrayCreatorFilling();
            repositoryArr = arrayCreatorFilling.createFill();
        }
        catch (ArrayException ex){
            throw new ServiceException(ex.getMessage(),ex);
        }
    }
    public Array getArray(){
        return repositoryArr;
    }
    public void setArray(Array a){repositoryArr=a;}

    /**
     * Сalls a factory DAO that gives the command to write an array to a file
     */
    public void putArrayIntoFile(){
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        ArrayDAO arrayDAO = daoObjectFactory.getTxtArrayDAO();
        arrayDAO.clearFile();
        arrayDAO.writeResultArrayToFile(repositoryArr.getArray());
    }
}
