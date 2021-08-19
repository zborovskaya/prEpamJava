package by.zborovskaya.task08.servise.parser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class CandiesSaxBuilder extends CandiesBuilder {
    private CandyHandler handler;
    private XMLReader reader;
    public CandiesSaxBuilder(String path) {
        handler = new CandyHandler(candies);
        // reader configuration
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            // create schema
            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            //"task08-XMLParsing/src/main/resources/data/candy.xsd"
            Schema schema = xsdFactory.newSchema(new File(path));
            // set schema
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            factory.setSchema(schema);
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace(); // log
        }
        reader.setErrorHandler(new CandyErrorHandler());
        reader.setContentHandler(handler);
    }
    @Override
    public void buildSetCandies(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
        candies = handler.getCandies();
    }
}

