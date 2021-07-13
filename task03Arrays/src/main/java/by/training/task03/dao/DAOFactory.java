package by.training.task03.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ArrayDAO txtArrayImpl = new ArrayDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public ArrayDAO getTxtArrayDAO(){
        return txtArrayImpl;
    }
}
