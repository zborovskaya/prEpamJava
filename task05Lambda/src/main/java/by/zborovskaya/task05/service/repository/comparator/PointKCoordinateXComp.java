package by.zborovskaya.task05.service.repository.comparator;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class PointKCoordinateXComp implements Comparator<Cone> {
    @Override
    /**
     * The function compare coordinate x
     * @param cone1
     * @param cone2
     * @return 1) 1, if coordinate x first cone more second cone
     *         2) 0, if coordinate x first cone equally second cone
     *         3)-1, if coordinate x first cone less second cone
     */
    public int compare(Cone cone1, Cone cone2) {
        Cone.PointCone pointCone1=cone1.getPointK();
        Cone.PointCone pointCone2=cone2.getPointK();
        double xCone1=pointCone1.getX();
        double xCone2=pointCone2.getX();
        return xCone1 > xCone2 ? 1 : xCone1 == xCone2 ? 0 : -1;
    }
}
