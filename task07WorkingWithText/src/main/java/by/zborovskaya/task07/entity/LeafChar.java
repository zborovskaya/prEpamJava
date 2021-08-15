package by.zborovskaya.task07.entity;

import java.util.ArrayList;

public class LeafChar implements ComponentText{
    private final  String DELIMiTER_SYMBOL="";
    private char symbol;

    public LeafChar(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public ArrayList<ComponentText> getListOfChildren() {
        return  null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeafChar)) return false;
        LeafChar that = (LeafChar) o;
        return symbol== that.getSymbol();
    }

    public char getSymbol() {
        return symbol;
    }

    public String collect(String del) {
        return DELIMiTER_SYMBOL + symbol;
    }
}
