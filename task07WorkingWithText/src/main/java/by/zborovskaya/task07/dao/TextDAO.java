package by.zborovskaya.task07.dao;

import java.util.List;

public interface TextDAO {
    String readData(String path);
    void writeData(String path);
    void clearData(String path);
}
