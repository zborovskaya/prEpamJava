package by.zborovskaya.task05.service;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeCreator {
    static final Logger logger = LogManager.getLogger(ConeCreator.class);

    /**
     * Function create cone
     * @param r
     * @param xM
     * @param yM
     * @param zM
     * @param xK
     * @param yK
     * @param zK
     * @return cone
     * if base not parallel Coordinate plane=> cone=null
     */
    public Cone create(double r,double xM, double yM, double zM, double xK, double yK, double zK)  {
        Cone cone = null;

        boolean fl=isParallel(xM, yM, zM, xK, yK, zK);
        //Рассматриваем случай, когда высота конуса равна 0 => пользователь задал круг
        if (fl||((xM==xK)&&(yM==yK)&&(zM==zK))) {
            cone = new Cone(r, xM, yM, zM, xK, yK, zK);
        } else {
            logger.error("The base of the cone is not parallel to one of the coordinate planes");
        }
        return cone;
    }

    /**
     *
     * @param xM
     * @param yM
     * @param zM
     * @param xK
     * @param yK
     * @param zK
     * @return 1)true, if base parallel coordinate plane
     *         2)false, if base is not parallel coordinate plane
     */
    public boolean isParallel(double xM, double yM, double zM, double xK, double yK, double zK)
    {
        // Проверяем параллельность высоты с одной из осей
        return (((xM==xK)&&(yM==yK)&&(zM!=zK))|| ((xM!=xK)&&(yM==yK)&&(zM==zK))||((xM==xK)&&(yM!=yK)&&(zM==zK)));
    }
}
