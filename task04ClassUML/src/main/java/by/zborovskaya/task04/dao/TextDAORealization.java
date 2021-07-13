package by.zborovskaya.task04.dao;
import by.zborovskaya.task04.entity.Sentence;
import by.zborovskaya.task04.entity.UserText;
import by.zborovskaya.task04.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class TextDAORealization implements TextDAO{
    private static final Logger logger = LogManager.getLogger(TextDAORealization.class);
    private String path="C:/Users/zav/IdeaProjects/prEpamJava/task04ClassUML/src/main/data/dataFile.txt";
    Scanner scanner;
    PrintWriter pw ;

    /**
     * The method fills the userText entity with data from a file( read file)
     * @return userText
     */
    public UserText readData() {
        Word word;
        Sentence sentence= new Sentence();
        UserText text=null;
        try {
            scanner = new Scanner(new File(path));
            word = new Word((scanner.next()));
            text = new UserText(word);
            while (scanner.hasNext()) {
                String str="";
                sentence.setValue(str);
                while (str.indexOf('.')==-1 && str.indexOf('!')==-1 && str.indexOf('?')==-1 && scanner.hasNext()) {
                    str = scanner.next();
                    word.setWord(str);
                    sentence.addWord(word);
                }
                text.addSentence(sentence);
            }
        } catch (Exception e ) {
            logger.error("Exception caught in TextRealizationDAO class in method readData().");
        }
        return text;
    }

    /**
     * The method makes the file empty
     */

    public void clearData() {
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.close();
        } catch (Exception e) {
            logger.error("Exception caught in TextRealizationDAO class in method clearData().");
        }
    }

    /**
     * The method reads information from a file into a class object UserText
     * @param text
     */
    public void writeData(UserText text) {
        clearData();
        String header = text.getHeadline();
        String words = text.getTextBody();
        try {
            pw = new PrintWriter(new FileWriter(path));
            pw.println(header);
            pw.println(words);
            pw.close();
        } catch (Exception e ) {
            logger.error("Exception caught in TextRealizationDAO class in method writeData().");
        }
    }
}
