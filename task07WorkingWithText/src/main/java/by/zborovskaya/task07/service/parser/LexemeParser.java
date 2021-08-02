package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeWord;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Handler {
    private static final String WORD_PATTERN ="(\\(?)([a-zA-Z]+(-?))+(\\)?)|\\.{3}|!\\?|\\?!|[-!?:;,.]";
    private static final String EXPRESSION_PATTERN = "[\\d/*+=|^><&~()]([^a-zA-Z]*)[-\\d/*+=|^><&~()]";
    private static final String LEXEME_PATTERN =WORD_PATTERN+"|"+EXPRESSION_PATTERN;

    public LexemeParser() {
        super();
    }

    public LexemeParser(Handler next) {
        super(next);
    }

    @Override
    public void parse(String data, BaseComposite lexemeComposite){
        Pattern pattern = Pattern.compile(LEXEME_PATTERN);
        Matcher word = pattern.matcher(data);
        if(checkNext()){
            while(word.find()){
                CompositeWord compositeWord=new CompositeWord();
                parseNext(word.group(), compositeWord);
                lexemeComposite.add(compositeWord);
            }
        }
    }
}
