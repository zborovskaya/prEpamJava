package by.zborovskaya.task04.service;

import by.zborovskaya.task04.dao.DAOFactory;
import by.zborovskaya.task04.dao.TextDAO;
import by.zborovskaya.task04.entity.Sentence;
import by.zborovskaya.task04.entity.UserText;
import by.zborovskaya.task04.entity.Word;
import by.zborovskaya.task04.view.ViewMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextRealizationService implements TextService{
    private static final Logger logger = LogManager.getLogger(ViewMain.class);

    DAOFactory daoObjectFactory = DAOFactory.getInstance();
    TextDAO textRealizationDAO = daoObjectFactory.getTextRealizationDAO();
    UserText userText=null;

    public String readHeadline(){
        userText=textRealizationDAO.readData();
        if( userText.getHeadline()=="") {
            logger.error("Headline is empty");
        } else {
            System.out.println(userText.getHeadline());
        }
        return userText.getHeadline();
    }
    public String showText(){
        userText=textRealizationDAO.readData();
        if(userText.getTextBody()==""&& userText.getHeadline()==""){
            logger.error("User try to enter empty File");
        }else {
            System.out.println(userText.toString());
        }
        return userText.toString();
    }
    public void addText(String textBody){

        userText=textRealizationDAO.readData();
        Sentence sentence= new Sentence();
        String[] words = textBody.split(" ");
        int i=0;
        while(i<words.length){
            Word word = new Word(words[i]);
            sentence.addWord(word);
            if(words[i].indexOf('.')!=-1 || words[i].indexOf('!')!=-1 || words[i].indexOf('?')!=-1 ||i>words.length-1) {
                userText.addSentence(sentence);
                sentence.setValue("");
            }
            i++;
            userText.addSentence(sentence);
            sentence.setValue("");
        }
        textRealizationDAO.writeData(userText);

    }

   public void createNewText(String  headline, String textBody){
       Word head = new Word(headline);
       UserText userText = new UserText(head);
       Sentence sentence= new Sentence();
       String[] words = textBody.split(" ");
       int i=0;
       while(i<words.length){
           Word word = new Word(words[i]);
           sentence.addWord(word);
           if(words[i].indexOf('.')!=-1 || words[i].indexOf('!')!=-1 || words[i].indexOf('?')!=-1 ||i>words.length-1) {
               userText.addSentence(sentence);
               sentence.setValue("");
           }
           i++;
           userText.addSentence(sentence);
           sentence.setValue("");
       }
       textRealizationDAO.writeData(userText);

   }
    public void clearText(){
        textRealizationDAO.clearData();
    }
}
