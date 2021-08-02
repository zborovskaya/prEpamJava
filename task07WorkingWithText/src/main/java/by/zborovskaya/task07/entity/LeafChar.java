package by.zborovskaya.task07.entity;

import java.util.ArrayList;

public class LeafChar implements ComponentText{
    private char symbol;

    public LeafChar(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public ArrayList<ComponentText> getListOfChildren() {
        return  null;

    }

    public char getSymbol() {
        return symbol;
    }

    public String collect(String del) {
        return "" + symbol;
    }


}