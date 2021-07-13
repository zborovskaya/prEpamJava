package by.zborovskaya.task05.service.repository.comparator;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class PointMCoordinateYComp implements Comparator<Cone> {
    /**
     * The function compare coordinate y
     * @param cone1
     * @param cone2
     * @return 1) 1, if coordinate y first cone more second cone
     *         2) 0, if coordinate y first cone equally second cone
     *         3)-1, if coordinate y first cone less second cone
     */
    @Override
    public int compare(Cone cone1, Cone cone2) {
        Cone.PointCone pointCone1=cone1.getPointM();
        Cone.PointCone pointCone2=cone2.getPointM();
        double yCone1=pointCone1.getY();
        double yCone2=pointCone2.getY();
        return yCone1 > yCone2 ? 1 : yCone1 == yCone2 ? 0 : -1;
    }
}
