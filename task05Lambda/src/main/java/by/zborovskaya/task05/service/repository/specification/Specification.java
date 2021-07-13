package by.zborovskaya.task05.service.repository.specification;

import by.zborovskaya.task05.entity.Cone;

public interface Specification {
    public boolean findMatches(Cone cone);
}
