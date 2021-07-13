package by.zborovskaya.task04.entity;

import java.util.Objects;

public class Sentence {
    private String value;

    public Sentence(){this.value ="";}

    public Sentence(String value){this.value = value;}
    //TODO +" "

    public void addWord(Word word) {
        value += word.getValue()+" ";
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(value, sentence.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
