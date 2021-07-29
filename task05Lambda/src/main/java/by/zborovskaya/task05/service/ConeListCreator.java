package by.zborovskaya.task05.service;

import by.zborovskaya.task05.dao.ConeDAO;
import by.zborovskaya.task05.dao.DAOFactory;
import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.exception.InputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeListCreator {
    static final Logger logger = LogManager.getLogger(ConeListCreator.class);
    private DAOFactory daoObject = DAOFactory.getInstance();
    private ConeDAO coneDAOImpl = daoObject.getConeDAOImpl();
    private ConeCreator creator= new ConeCreator();
    private ConeValidator validator= new ConeValidator();
    private ConeParser coneParser= new ConeParser();

    /**
     * Function create list of cones
     * If list of cones is empty, throw exception
     * @param path path to file
     * @return list of cones
     */

    public List<Cone> createList(String path) throws InputException {
        List<Cone> coneList = new ArrayList<Cone>();
        List<String> data = coneDAOImpl.readData(path);
        for (String line : data) {
            if (validator.isValid(line)) {
                double[] param = coneParser.create(line);
                Cone cone=creator.create(param[0], param[1], param[2], param[3], param[4], param[5], param[6]);
                if (cone == null) {
                    continue;
                }
                coneList.add(cone);
            }
        }
        if (coneList.size() == 0) {
            logger.error("Error in creating cone: ");
            throw new InputException("Error. Suitable data not found");
        }
        return coneList;
    }
}
