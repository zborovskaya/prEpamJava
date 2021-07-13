package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdSearch implements Specification{
    static final Logger logger = LogManager.getLogger(IdSearch.class);
    private int id;

    public IdSearch(int id) {
        this.id = id;
    }
    /**
     * Function find cone with coordinate id
     * @param cone
     * @return 1)true, if there is id
     *         2)false, if there is not id
     */
    public boolean findMatches(Cone cone){
        if (cone == null) {
            logger.error("Cone can not be null");
        }
        return id==cone.getId();
    }
}
