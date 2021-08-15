package by.zborovskaya.task07.entity;

import java.util.ArrayList;

public interface ComponentText {
    String collect(String del);
    ArrayList<ComponentText> getListOfChildren();
}

