package by.zborovskaya.task07.service.functional;

import by.zborovskaya.task07.dao.DAOFactory;
import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeText;
import by.zborovskaya.task07.service.parser.*;

public class CompositeTextCreator {
    public CompositeText create(String path ){
        String data= DAOFactory.getInstance().getDAOImpl().readData("./task07WorkingWithText/data/inputData.txt");
        WordParser wordParser=new WordParser();
        LexemeParser lexemeParser=new LexemeParser(wordParser);
        SentenceParser sentenceParser=new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser=new ParagraphParser(sentenceParser);
        TextParser textParser=new TextParser(paragraphParser);
        CompositeText compositeText=new CompositeText();
        textParser.parse(data,compositeText);
        return compositeText;
    }
}
