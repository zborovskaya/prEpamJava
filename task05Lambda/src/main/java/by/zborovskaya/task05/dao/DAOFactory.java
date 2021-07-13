package by.zborovskaya.task05.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final ConeDAO coneDao = new ConeDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public ConeDAO getConeDAOImpl() { return coneDao; }
}
