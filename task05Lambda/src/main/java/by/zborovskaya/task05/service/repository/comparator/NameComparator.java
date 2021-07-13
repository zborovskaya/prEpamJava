package by.zborovskaya.task05.service.repository.comparator;

import by.zborovskaya.task05.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class NameComparator implements Comparator<Cone> {
    /**
     * The function compare name
     * @param cone1
     * @param cone2
     * @return 1) 1, if name first cone more second cone
     *         2) 0, if name first cone equally second cone
     *         3)-1, if name first cone less second cone
     */
    @Override
    public int compare(Cone cone1, Cone cone2) {
        return cone1.getName().compareTo(cone2.getName());
    }
}
