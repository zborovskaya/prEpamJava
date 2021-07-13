package by.zborovskaya.task05.service.repository;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.repository.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeRepository implements Repository, ConeSort {

    static final Logger logger = LogManager.getLogger(ConeRepository.class);

    private List<Cone> coneList;
    private static ConeRepository instance;

    private ConeRepository(List<Cone> coneList) {
        this.coneList = coneList;
    }

    public static ConeRepository getInstance(List<Cone> coneList) {
        if (instance == null) {
            instance = new ConeRepository(coneList);
        }
        return instance;
    }

    public List<Cone> getConeList() {
        return coneList;
    }

    /**
     * Function sort list of cones
     * @param comparator sets the sorting criterion
     */

    @Override
    public void sort(Comparator comparator) {
        if (comparator == null) {
            logger.error("Comparator can't be null");
            throw new IllegalArgumentException("Error in sort");
        }
        coneList.sort(comparator);
    }

    /**
     *Function add cone to list of cone
     * @param cone
     */

    @Override
    public void add(Cone cone) {
        if (cone == null) {
            logger.error("Cone can't be null");
            throw new IllegalArgumentException("Error in adding an cone");
        }
        coneList.add(cone);
    }

    /**
     * Function finds a group of cones given by the specifier
     * @param specification
     * @return
     */

    @Override
    public List<Cone> find(Specification specification) {
        if (specification == null) {
            logger.error("specification can't be null");
            throw new IllegalArgumentException("Error in find");
        }
        List<Cone> selectedConeList  = new ArrayList<>();
        if (!coneList.isEmpty()) {
            for (Cone cone : coneList) {
                if (specification.findMatches(cone)) {
                    selectedConeList.add(cone);
                }
            }
        }
        return selectedConeList;
    }

    /**
     * Function remove cone of list of cones
     * @param cone
     */

    @Override
    public void remove(Cone cone) {
        if (cone == null) {
            logger.error("Cone can't be null");
            throw new IllegalArgumentException("Error in removing an oval");
        }
        coneList.remove(cone);
    }

    /**
     * Function update cone's parameters  of list of cones
     * @param coneNew cone with new parameters
     */

    @Override
    public void update(Cone coneNew) {
        if (coneNew == null) {
            logger.error("Cone can't be null");
            throw new IllegalArgumentException("Error in updating");
        }
        int idConeNew = coneNew.getId();
        int index = -1;
        for (Cone cone : coneList) {
            Integer idConeOld = cone.getId();
            if (idConeNew==idConeOld) {
                index = coneList.indexOf(cone);
                break;
            }
        }
        if (index != -1) {
            coneList.set(index, coneNew);
        }
    }
}
