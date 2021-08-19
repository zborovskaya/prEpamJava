package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeParagraph;

public class TextParser extends Handler {
    private static final String TEXT_PATTERN ="\r\n\t";
    public TextParser() {
        super();
    }

    public TextParser(Handler next) {
        super(next);
    }

    @Override
    public void parse(String data, BaseComposite compositeText){
        String[] paragraphs = data.trim().split(TEXT_PATTERN);
        if(checkNext()){
            for (String paragraph:paragraphs){
                CompositeParagraph compositeParagraph=new CompositeParagraph();
                parseNext(paragraph, compositeParagraph);
                compositeText.add(compositeParagraph);
            }
        }
    }

}
