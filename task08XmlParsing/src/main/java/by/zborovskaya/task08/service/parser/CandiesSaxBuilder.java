package by.zborovskaya.task08.service.parser;
import by.zborovskaya.task08.entity.Candy;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;
public class CandiesSaxBuilder {
    private Set<Candy> candies;
    private CandyHandler handler = new CandyHandler();
    private XMLReader reader;
    public CandiesSaxBuilder() {
        // reader configuration
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        try {
//            SAXParser saxParser = factory.newSAXParser();
//            reader = saxParser.getXMLReader();
//        } catch (ParserConfigurationException | SAXException e) {
//            e.printStackTrace(); // log
//        }
//        reader.setErrorHandler(new CandyErrorHandler());
//        reader.setContentHandler(handler);
//    }
//    public Set<Candy> getCandies() {
//        return candies;
//    }
//    public void buildSetCandies(String filename) {
//        try {
//            reader.parse(filename);
//        } catch (IOException | SAXException e) {
//            e.printStackTrace(); // log
//        }
//        candies = handler.getCandies();
    }
}

