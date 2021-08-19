package by.zborovskaya.task07.service.parser;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeSentence;

public class ParagraphParser extends Handler {
    private static final String PARAGRAPH_PATTERN ="(?<=\\!|\\?|\\.{3}|\\.)\\s+";

    public ParagraphParser() {
        super();
    }

    public ParagraphParser(Handler next) {
        super(next);
    }

    @Override
    public void parse(String data, BaseComposite paragraphComposite){
        String[] sentences = data.trim().split(PARAGRAPH_PATTERN);
        if(checkNext()){
            for (String sentence:sentences){
                CompositeSentence compositeSentence=new CompositeSentence();
                parseNext(sentence, compositeSentence);
                paragraphComposite.add(compositeSentence);
            }
        }
    }
}
