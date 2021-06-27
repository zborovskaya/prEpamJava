package by.zborovskaya.task04.entity;

public class UserText {
    private String headline;
    private String textBody;

    public UserText(){
        headline="";
        textBody="";
    }

    public UserText(Word word) {

        headline = word.getValue();
        textBody="";
    }

    public UserText(Sentence sentence) {
        headline = sentence.getValue();
        textBody="";
    }

    public void addWord(Word word) {textBody += word.getValue()+" ";}

    public void addSentence(Sentence sentence) {
        textBody += sentence.getValue();
    }

    public String getHeadline() {
        return headline;
    }

    public String getTextBody() {
        return textBody;
    }

    @Override
    public String toString() {
        return "Text{" +
                "header='" + headline + '\'' +
                ", body='" + textBody + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserText text = (UserText) o;
        return (headline==text.headline) && (textBody==text.textBody);
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }
}
