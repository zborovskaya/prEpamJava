package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.ComponentText;
import by.zborovskaya.task07.entity.LeafChar;

public class WordParser extends Handler {

    public WordParser() {
        super();
    }

    public WordParser(Handler next) {
        super(next);
    }

    @Override
    public void parse(String data, BaseComposite word){
        char[] symbols = data.toCharArray();
        for (char sym:symbols){
            word.add(new LeafChar(sym));
        }
    }
}
