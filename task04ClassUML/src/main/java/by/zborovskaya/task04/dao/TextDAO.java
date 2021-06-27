package by.zborovskaya.task04.dao;

import by.zborovskaya.task04.entity.UserText;

public interface TextDAO {
    UserText readData();
    void writeData(UserText text);
    void clearData();
}
