package by.zborovskaya.task05.dao;

import by.zborovskaya.task05.entity.Cone;

import java.util.List;

public interface ConeDAO {
    List<String> readData(String path);
    void writeData(String path, Cone cone);
    void clearData(String path);
}
