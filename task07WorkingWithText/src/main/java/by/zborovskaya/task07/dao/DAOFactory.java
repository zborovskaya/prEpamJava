package by.zborovskaya.task07.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final TextDAO txtDao = new TextDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextDAO getDAOImpl() {
        return txtDao;
    }
}
