package by.zborovskaya.task05.service.repository.comparator;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.exception.ConeNotFoundException;
import by.zborovskaya.task05.service.repository.ConeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class IdComparator implements Comparator<Cone> {

    /**
     * The function compare id
     * @param cone1
     * @param cone2
     * @return 1) 1, if id first cone more second cone
     *         2) 0, if id first cone equally second cone
     *         3)-1, if id first cone less second cone
     */

    @Override
    public int compare(Cone cone1, Cone cone2)  {
        Integer cone1Id = cone1.getId();
        Integer cone2Id = cone2.getId();
        return cone1Id > cone2Id ? 1 : cone1Id == cone2Id ? 0 : -1;
    }
}
