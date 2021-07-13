package by.zborovskaya.task05.service.repository.comparator;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class PointMCoordinateZComp implements Comparator<Cone> {
    /**
     * The function compare coordinate z
     * @param cone1
     * @param cone2
     * @return 1) 1, if coordinate z first cone more second cone
     *         2) 0, if coordinate z first cone equally second cone
     *         3)-1, if coordinate z first cone less second cone
     */
    @Override
    public int compare(Cone cone1, Cone cone2) {
        Cone.PointCone pointCone1=cone1.getPointM();
        Cone.PointCone pointCone2=cone2.getPointM();
        double zCone1=pointCone1.getZ();
        double zCone2=pointCone2.getZ();
        return zCone1 > zCone2 ? 1 : zCone1 == zCone2 ? 0 : -1;
    }
}
