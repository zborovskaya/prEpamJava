package by.zborovskaya.task04.entity;

import java.util.Objects;

public class Word {
    private String value;

    public Word(String value) {
        this.value = value;
    }
    public void setWord(String value){this.value = value;}
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
