package by.zborovskaya.task07.service.functional;

import by.zborovskaya.task07.dao.DAOFactory;
import by.zborovskaya.task07.entity.CompositeText;
import by.zborovskaya.task07.service.parser.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompositeTextCreator {
    private static final Logger logger = LogManager.getLogger(CompositeTextCreator.class);

    /**
     * Receives text and creates CompositeText
     * @param path
     * @return
     */
    public CompositeText create(String path ){
        //"./task07WorkingWithText/data/inputData.txt"
        CompositeText compositeText=null;
        try {
            String data= DAOFactory.getInstance().getDAOImpl().readData(path);
            WordParser wordParser=new WordParser();
            LexemeParser lexemeParser=new LexemeParser(wordParser);
            SentenceParser sentenceParser=new SentenceParser(lexemeParser);
            ParagraphParser paragraphParser=new ParagraphParser(lexemeParser);
            TextParser textParser=new TextParser(paragraphParser);
            compositeText=new CompositeText();
            textParser.parse(data,compositeText);
//            lexemeParser.parse(data,compositeText);
        }catch (Exception ex){
            logger.error("Error in CompositeTextCreator.");
        }
        return compositeText;
    }
    public static void main(String[] args) {
        CompositeTextCreator compositeTextCreator=new CompositeTextCreator();
        CompositeText compositeText=compositeTextCreator.create("./task07WorkingWithText/data/inputData.txt");
        System.out.println(compositeText.collect(""));
    }
}
