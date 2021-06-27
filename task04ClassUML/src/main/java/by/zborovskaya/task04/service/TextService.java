package by.zborovskaya.task04.service;

import by.zborovskaya.task04.entity.UserText;

import java.util.Scanner;

public interface TextService {
    String readHeadline();
    String showText();
    void addText(String textBody);
    void createNewText(String  headline, String textBody);
    void clearText();
}
