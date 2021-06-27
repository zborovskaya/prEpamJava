package by.zborovskaya.task04.entity;

public class Word {
    private String value;

    public Word(String value) {
        this.value = value;
    }
    public void replaceWord(String value){this.value = value;}
    public String getValue() {
        return value;
    }
}
