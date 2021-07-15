package by.zborovskaya.task06.dao;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final MatrixDAO matrixDAO = new MatrixDAOImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public MatrixDAO getMatrixDAOImpl() { return matrixDAO; }
}
