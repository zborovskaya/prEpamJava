package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinateYSearch implements Specification{
    static final Logger logger = LogManager.getLogger(CoordinateYSearch.class);
    private double y;

    public CoordinateYSearch(double y) {
        this.y = y;
    }
    /**
     * Function find cone with coordinate y
     * @param cone
     * @return 1)true, if there is y
     *         2)false, if there is not y
     */

    public boolean findMatches(Cone cone) {
        if (cone == null) {
            logger.error("Cone can not be null");
        }
        Cone.PointCone pointK= cone.getPointK();
        Cone.PointCone pointM= cone.getPointM();
        return y == pointK.getY() ||
                y == pointM.getY();
    }
}
