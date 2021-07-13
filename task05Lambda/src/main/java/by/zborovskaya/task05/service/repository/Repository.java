package by.zborovskaya.task05.service.repository;

import by.zborovskaya.task05.entity.Cone;
import by.zborovskaya.task05.service.repository.specification.Specification;

import java.util.List;

public interface Repository {
    void add(Cone cone);
    List<Cone> find(Specification specification);
    void remove(Cone cone);
    void update(Cone cone);
}
