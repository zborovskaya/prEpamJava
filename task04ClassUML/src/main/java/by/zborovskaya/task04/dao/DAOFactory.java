package by.zborovskaya.task04.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final TextDAO txtDao = new TextDAORealization();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextDAO getTextRealizationDAO() {
        return txtDao;
    }
}
