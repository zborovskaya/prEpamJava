package by.training.task03.service;

import by.training.task03.dao.ArrayDAO;
import by.training.task03.dao.DAOFactory;
import by.training.task03.entity.Array;
import by.training.task03.service.exception.ArrayException;

public class ArrayCreatorFilling {
    /**
     * The function create and fill array
     * @return
     * @throws ArrayException, if n<0
     */

    public  Array createFill() throws ArrayException
    {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        ArrayDAO arrayDAO = daoObjectFactory.getTxtArrayDAO();
        int[] a = arrayDAO.readArrayFromFile();
        int n=a.length;
        Array array = null;
        if (isValid(n)) {
            array = new Array(n);
            for (int i=0; i<array.getLength(); i++){
                array.setValues(i,a[i]);
            }
        }
        else throw new ArrayException("Array parameters entered incorrectly!");
        return array;
    }

    private boolean isValid(int n)
    {
        return (n>0 );
    }


}
