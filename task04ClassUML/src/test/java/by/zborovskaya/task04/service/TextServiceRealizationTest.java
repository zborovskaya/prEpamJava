package by.zborovskaya.task04.service;

import by.zborovskaya.task04.entity.Sentence;
import by.zborovskaya.task04.entity.UserText;
import by.zborovskaya.task04.entity.Word;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextServiceRealizationTest {

    @Test
    public void testServiceText() {
        TextServiceRealization textRealizationService= new TextServiceRealization();
        Word head=new Word("Hello");
        Sentence sentenceExpected=new Sentence("Hello! My name is Ann. ");
        UserText expected=new UserText(head);
        expected.addSentence(sentenceExpected);
        textRealizationService.clearText();
        textRealizationService.createNewText("Hello","Hello! My name is Ann.");
        String result=textRealizationService.showText();
        Assert.assertEquals(result, expected.toString());

    }
}