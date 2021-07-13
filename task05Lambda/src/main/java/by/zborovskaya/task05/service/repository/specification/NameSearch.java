package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NameSearch implements Specification{
    static final Logger logger = LogManager.getLogger(NameSearch.class);
    private String name;

    public NameSearch(String name) {
        this.name = name;
    }
    /**
     * Function find cone with coordinate name
     * @param cone
     * @return 1)true, if there is name
     *         2)false, if there is not name
     */
    public boolean findMatches(Cone cone){
        if (cone == null) {
            logger.error("Cone can not be null");
        }
        return cone.getName().equals(name);
    }
}
