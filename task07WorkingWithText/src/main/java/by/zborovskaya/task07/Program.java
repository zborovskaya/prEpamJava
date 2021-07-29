package by.zborovskaya.task07;

import by.zborovskaya.task07.dao.DAOFactory;
import by.zborovskaya.task07.entity.*;
import by.zborovskaya.task07.service.parser.*;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

//        LeafChar leafChar1=new LeafChar('I');
//        CompositeWord i=new CompositeWord();
//        i.add(leafChar1);
//        CompositeLexeme iL=new CompositeLexeme();
//        iL.add(i);
//        LeafChar leafChar2=new LeafChar('l');
//        LeafChar leafChar3=new LeafChar('o');
//        LeafChar leafChar4=new LeafChar('v');
//        LeafChar leafChar5=new LeafChar('e');
//        CompositeWord love=new CompositeWord();
//        love.add(leafChar2);
//        love.add(leafChar3);
//        love.add(leafChar4);
//        love.add(leafChar5);
//        CompositeLexeme loveL=new CompositeLexeme();
//        loveL.add(love);
//        System.out.println(loveL.collect(""));
//        CompositeSentence iLove= new CompositeSentence();
//        iLove.add(iL);
//        iLove.add(loveL);
//        CompositeParagraph paragraph1=new CompositeParagraph();
//        paragraph1.add(iLove);
//        LeafChar leafChar6=new LeafChar('Y');
//        LeafChar leafChar7=new LeafChar('o');
//        LeafChar leafChar8=new LeafChar('u');
//        CompositeWord word=new CompositeWord();
//        word.add(leafChar6);
//        word.add(leafChar7);
//        word.add(leafChar8);
//        CompositeLexeme wordL=new CompositeLexeme();
//        wordL.add(word);
//        CompositeSentence youS= new CompositeSentence();
//        youS.add(wordL);
//        CompositeParagraph paragraph2=new CompositeParagraph();
//        paragraph2.add(youS);
//        CompositeText text=new CompositeText();
//        text.add(paragraph1);
//        text.add(paragraph2);
//        System.out.println(text.collect(""));



        String data=DAOFactory.getInstance().getDAOImpl().readData("./task07WorkingWithText/data/inputData.txt");
        WordParser wordParser=new WordParser();
        LexemeParser lexemeParser=new LexemeParser(wordParser);
        SentenceParser sentenceParser=new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser=new ParagraphParser(sentenceParser);
        TextParser textParser=new TextParser(paragraphParser);
        CompositeText compositeText=new CompositeText();
        textParser.parse(data,compositeText);
        System.out.println(compositeText.collect(""));
    }
}
