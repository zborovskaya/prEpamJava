package by.zborovskaya.task07.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextDAOImpl implements TextDAO{
    static final Logger logger = LogManager.getLogger(TextDAOImpl.class);
    /**
     * Function read data from file
     * @param path
     * @return
     */

    @Override
    public String readData(String path) {
        //String PATH="./task07WorkingWithText/data/inputData.txt"

        String txt = null;
        try {
            txt = Files.lines(Paths.get(path))
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt;
    }

    @Override
    public void writeData(String path) {

    }

    @Override
    public void clearData(String path) {

    }
    public static void main(String[] args) {
//        TextDAOImpl textDAO=new TextDAOImpl();
//        String data =textDAO.readData("./task07WorkingWithText/data/inputData.txt");
//        System.out.println(data);
        String data="It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, " +
                "remaining 30>>>3 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(25^5|6&47)" +
                "|3)|2)|1) with the release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "\n" +
                "\tIt is a long established fact that a reader will be distracted by the readable content of a page" +
                " when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 " +
                "Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here)," +
                " content here', making it look like readable English.\n" +
                "\tIt is a (111^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page " +
                "when looking at its layout.\n" +
                "\tBye.";
//        String[] parameters = data.trim().split("(\\s*\\b\\s*)|\\s+");
//        for(String parameter: parameters) System.out.println(parameter);

//        Pattern pattern = Pattern.compile("\\.(?!\\.)|[\\!\\?\\-\\:\\;\\,]");
//
//        Pattern pattern = Pattern.compile("[^-!?:;,.()\\s+]");
        //Выражение для разделения лексемы на слова
//        Pattern pattern = Pattern.compile("\\.{3}|\\!\\?|\\?!|[-!?:;,.]|(?<=[a-zA-Z])\\)|[a-zA-Z]+");

// Регулярное выражение для выражения
        Pattern pattern = Pattern.compile("(\\(?)([a-zA-Z]+(-?))+(\\)?)|\\.{3}|!\\?|\\?!|[-!?:;,.]");

        Matcher matcher = pattern.matcher(data);
        while(matcher.find())
            System.out.println(matcher.group());
    }
}
