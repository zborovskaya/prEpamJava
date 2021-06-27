package by.zborovskaya.task04.entity;

public class Sentence {
    private String value;

    public Sentence(){this.value ="";}

    public Sentence(String value){this.value = value;}

    public void addWord(Word word) {
        value += word.getValue()+" ";
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
