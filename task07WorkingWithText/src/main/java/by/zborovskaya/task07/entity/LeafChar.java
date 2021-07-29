package by.zborovskaya.task07.entity;

public class LeafChar implements ComponentText{
    private char symbol;

    public LeafChar(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String collect(String del) {
        return "" + symbol;
    }


}
