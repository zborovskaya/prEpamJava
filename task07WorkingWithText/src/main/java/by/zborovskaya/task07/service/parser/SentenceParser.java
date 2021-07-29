package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeLexeme;

public class SentenceParser extends Handler {

    public SentenceParser() {
        super();
    }

    public SentenceParser(Handler next) {
        super(next);
    }

    @Override
    public void parse(String data, BaseComposite sentenceComposite){
        String[] lexemes = data.trim().split("\\s+");
        if(checkNext()){
            for (String lexeme:lexemes){
                CompositeLexeme compositeLexeme=new CompositeLexeme();
                parseNext(lexeme, compositeLexeme);
                sentenceComposite.add(compositeLexeme);
            }
        }
    }
}
