package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinateXSearch implements Specification{
    static final Logger logger = LogManager.getLogger(CoordinateXSearch.class);

    private double x;

    public CoordinateXSearch(double x) {
        this.x = x;
    }

    /**
     * Function find cone with coordinate x
     * @param cone
     * @return 1)true, if there is x
     *         2)false, if there is not x
     */

    public boolean findMatches(Cone cone) {
        if (cone == null) {
            logger.error("Cone can not be null");
        }
        Cone.PointCone pointK= cone.getPointK();
        Cone.PointCone pointM= cone.getPointM();

        return x == pointK.getX() ||
                x == pointM.getX();
    }
}
