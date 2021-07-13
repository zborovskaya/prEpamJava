package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinateZSearch implements Specification{
    static final Logger logger = LogManager.getLogger(CoordinateZSearch.class);
    private double z;

    public CoordinateZSearch(double z) {
        this.z = z;
    }
    /**
     * Function find cone with coordinate z
     * @param cone
     * @return 1)true, if there is z
     *         2)false, if there is not z
     */
    public boolean findMatches(Cone cone) {
        if (cone == null) {
           logger.error("Cone can not be null");
        }
        Cone.PointCone pointK= cone.getPointK();
        Cone.PointCone pointM= cone.getPointM();

        return z == pointK.getZ() ||
                z == pointM.getZ();
    }
}
