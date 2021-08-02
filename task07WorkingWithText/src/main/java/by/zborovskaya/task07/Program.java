package by.zborovskaya.task07;

import by.zborovskaya.task07.dao.DAOFactory;
import by.zborovskaya.task07.entity.*;
import by.zborovskaya.task07.service.functional.ComponentSorter;
import by.zborovskaya.task07.service.parser.*;

public class Program {
    public static void main(String[] args) {

        String data=DAOFactory.getInstance().getDAOImpl().readData("./task07WorkingWithText/data/inputData.txt");
        WordParser wordParser=new WordParser();
        LexemeParser lexemeParser=new LexemeParser(wordParser);
        SentenceParser sentenceParser=new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser=new ParagraphParser(sentenceParser);
        TextParser textParser=new TextParser(paragraphParser);
        CompositeText compositeText=new CompositeText();
        textParser.parse(data,compositeText);
        System.out.println(compositeText.collect(""));
// Проверка сортировка абзацев по количеству предложений
        ComponentSorter componentSorter=new ComponentSorter();
//        BaseComposite newText=componentSorter.sortParagraphs(compositeText);
//        System.out.println(newText.collect(""));

        //Проверка сортировки слов по их длинам
//        BaseComposite newText=componentSorter.sortWordsInSentences(compositeText);
//        System.out.println(newText.collect(""));

 // Третья функция, сортирует лексемы по количеству заданного символа, а потом по алфавиту
//        BaseComposite newText=componentSorter.sortLexemesInText(compositeText,'e');
//        System.out.println(newText.collect(""));
    }
}
