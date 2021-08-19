package by.zborovskaya.task07.entity;

import java.util.ArrayList;

public class TextOfLexemes extends BaseComposite{
    private final  String DELIMiTER_LEXEME=" ";

    public void fill(CompositeText compositeText){
        ArrayList<ComponentText> paragraphs=compositeText.getListOfChildren();
        for(ComponentText paragraph:paragraphs){
            ArrayList<ComponentText> sentences=paragraph.getListOfChildren();
            for(ComponentText sentence:sentences){
                ArrayList<ComponentText> lexemes=sentence.getListOfChildren();
                lexemes.forEach(lexeme->add(lexeme));
            }
        }
    }
    @Override
    public String collect(String del) {
        return super.collect(DELIMiTER_LEXEME);
    }

    @Override
    public TextOfLexemes clone() {
        TextOfLexemes composite = new TextOfLexemes();
        for (ComponentText component : getListOfChildren()) {
            composite.add(component);
        }
        return composite;
    }
}
