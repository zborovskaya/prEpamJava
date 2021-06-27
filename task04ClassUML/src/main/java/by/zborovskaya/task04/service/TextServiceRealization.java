package by.zborovskaya.task04.service;

import by.zborovskaya.task04.dao.DAOFactory;
import by.zborovskaya.task04.dao.TextDAO;
import by.zborovskaya.task04.entity.Sentence;
import by.zborovskaya.task04.entity.UserText;
import by.zborovskaya.task04.entity.Word;
import by.zborovskaya.task04.view.ViewMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextServiceRealization implements TextService{
    private static final Logger logger = LogManager.getLogger(TextServiceRealization.class);

    DAOFactory daoObjectFactory = DAOFactory.getInstance();
    TextDAO textRealizationDAO = daoObjectFactory.getTextRealizationDAO();

    /**
     * The method sends a request for a file to the DAO,
     * receives an object userText of the class and prints the Text's header to the console
     * @return Text's header
     */
    public String readHeadline(){
        UserText userText=textRealizationDAO.readData();
        if( userText.getHeadline()=="") {
            logger.error("Headline is empty");
        } else {
            System.out.println(userText.getHeadline());
        }
        return userText.getHeadline();
    }

    /**
     * The method sends a request for a file to the DAO,
     * receives an object userText of the class and prints the Text  to the console
     * @return Text
     */
    public String showText(){
        UserText userText=textRealizationDAO.readData();
        if(userText.getTextBody()==""&& userText.getHeadline()==""){
            logger.error("User try to enter empty File");
        }else {
            System.out.println(userText.toString());
        }
        return userText.toString();
    }

    /**
     * The method asks for the original text
     * and removes new information in the text
     * @param textBody - user data
     */
    public void addText(String textBody){

        UserText  userText=textRealizationDAO.readData();
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

    /**
     * The method creates a UserText object
     * and sends the object to DAO for writing to a file
     * @param headline- user data
     * @param textBody- user data
     */

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

    /**
     * The method clears the data from the file
     */
    public void clearText(){
        textRealizationDAO.clearData();
    }
}
