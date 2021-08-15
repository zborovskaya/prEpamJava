package by.zborovskaya.task07.service.functional;

import by.zborovskaya.task07.entity.BaseComposite;
import by.zborovskaya.task07.entity.CompositeText;
import by.zborovskaya.task07.entity.TextOfLexemes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComponentSorterTest {
    private  CompositeText compositeText;
    private ComponentSorter componentSorter;
    private CompositeTextCreator compositeTextCreator;
    private BaseComposite expected;

    @Before
    public void init() {
        compositeTextCreator=new CompositeTextCreator();
        compositeText=compositeTextCreator.create("./data/inputData.txt");
        componentSorter=new ComponentSorter();
    }
    @Test
    public void sortParagraphs() {
        expected =compositeTextCreator.create("./data/sortParagraphs.txt");
        BaseComposite actual=componentSorter.sortParagraphs(compositeText);
        assertEquals(expected,actual);


    }

    @Test
    public void sortWordsInSentences() {
        expected =compositeTextCreator.create("./data/sortWords.txt");
        BaseComposite actual=componentSorter.sortWordsInSentences(compositeText);
        assertEquals(expected.collect(""),actual.collect(""));
    }

    @Test
    public void sortLexemesInText() {
        expected =compositeTextCreator.create("./data/sortLexemes.txt");
        TextOfLexemes textOfLexemesExpected=new TextOfLexemes();
        textOfLexemesExpected.fill((CompositeText) expected);
        BaseComposite actual=componentSorter.sortLexemesInText(compositeText,'e');
        assertEquals(textOfLexemesExpected.collect(""),actual.collect(""));
    }
}