package by.zborovskaya.task08.service.parser;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import by.zborovskaya.task08.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class CandiesDomBuilder {
    private Set<Candy> candies;
    private DocumentBuilder docBuilder;
    public CandiesDomBuilder() {
        candies = new HashSet<Candy>();
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            // create schema
            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            Schema schema = xsdFactory.newSchema(new File("C:\\Users\\zav" +
                    "\\IdeaProjects\\prEpamJava\\task08XmlParsing\\src\\main\\resources\\data\\candy.xsd"));
            // set schema
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            factory.setSchema(schema);
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException | SAXException e){
            e.printStackTrace(); // log
        }
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void buildSetCandies(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            // getting a list of <candy> child elements
            NodeList caramelCandiesList = root.getElementsByTagName("caramelCandy");
            for (int i = 0; i < caramelCandiesList.getLength(); i++) {
                Element candyElement = (Element) caramelCandiesList.item(i);
                Candy candy = buildCaramelCandy(candyElement);
                candies.add(candy);
            }
            NodeList chocolateCandiesList = root.getElementsByTagName("chocolateCandy");
            for (int i = 0; i < chocolateCandiesList.getLength(); i++) {
                Element candyElement = (Element) chocolateCandiesList.item(i);
                Candy candy = buildChocolateCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Candy buildCaramelCandy(Element candyElement) {
        CaramelCandy caramelCandy=new CaramelCandy();
        // add null check
        caramelCandy.setMarking(candyElement.getAttribute("marking"));
        caramelCandy.setName(getElementTextContent(candyElement, "name"));
        caramelCandy.setDateProduction(getElementTextContent(candyElement, "dateProduction"));
        Integer en = Integer.parseInt(getElementTextContent(candyElement, "energy"));
        caramelCandy.setEnergy(en);
        caramelCandy.setProduction(getElementTextContent(candyElement, "production"));
        ProductValue productValue=caramelCandy.getProductValue();
        // init productValue object
        Element valueElement =
                (Element) candyElement.getElementsByTagName("value").item(0);
        productValue.setCarbohydrates(Double
                .parseDouble(getElementTextContent(valueElement, "carbohydrates")));
        productValue.setFats(Double.parseDouble(getElementTextContent(valueElement, "fats")));
        productValue.setProteins(Double.parseDouble(getElementTextContent(valueElement, "proteins")));
        // init ingredientsCaramel object
        Ingredients ingredientsCaramel=caramelCandy.getIngredientsCaramel();
        Element ingredientsCaramelElement =
                (Element) candyElement.getElementsByTagName("ingredientsCaramel").item(0);
        ingredientsCaramel.setFructose(Double.parseDouble(getElementTextContent(ingredientsCaramelElement,
                "fructose")));
        ingredientsCaramel.setSugar(Double.parseDouble(getElementTextContent(ingredientsCaramelElement,
                "sugar")));
        ingredientsCaramel.setWater(Double.parseDouble(getElementTextContent(ingredientsCaramelElement,
                "water")));
        ingredientsCaramel.setVanillin(Double.parseDouble(getElementTextContent(ingredientsCaramelElement,
                "vanillin")));
        return caramelCandy;
    }
    private Candy buildChocolateCandy(Element candyElement) {
        ChocolateCandy chocolateCandy=new ChocolateCandy();
        chocolateCandy.setMarking(candyElement.getAttribute("marking"));
        chocolateCandy.setFilling(candyElement.getAttribute("filling"));
        chocolateCandy.setName(getElementTextContent(candyElement, "name"));
        chocolateCandy.setDateProduction(getElementTextContent(candyElement, "dateProduction"));
        Integer en = Integer.parseInt(getElementTextContent(candyElement, "energy"));
        chocolateCandy.setEnergy(en);
        chocolateCandy.setProduction(getElementTextContent(candyElement, "production"));
        ProductValue productValue=chocolateCandy.getProductValue();
        // init productValue object
        Element valueElement =
                (Element) candyElement.getElementsByTagName("value").item(0);
        productValue.setCarbohydrates(Double
                .parseDouble(getElementTextContent(valueElement, "carbohydrates")));
        productValue.setFats(Double.parseDouble(getElementTextContent(valueElement, "fats")));
        productValue.setProteins(Double.parseDouble(getElementTextContent(valueElement, "proteins")));
        // init ingredientsCaramel object
        IngredientsChocolate ingredientsChocolate=chocolateCandy.getIngredientsChocolate();
        Element ingredientsChocolateElement =
                (Element) candyElement.getElementsByTagName("ingredientsChocolate").item(0);
        ingredientsChocolate.setFructose(Double.parseDouble(getElementTextContent(ingredientsChocolateElement,
                "fructose")));
        ingredientsChocolate.setSugar(Double.parseDouble(getElementTextContent(ingredientsChocolateElement,
                "sugar")));
        ingredientsChocolate.setWater(Double.parseDouble(getElementTextContent(ingredientsChocolateElement,
                "water")));
        ingredientsChocolate.setVanillin(Double.parseDouble(getElementTextContent(ingredientsChocolateElement,
                "vanillin")));
        ingredientsChocolate.setChocolateType(getElementTextContent(ingredientsChocolateElement,
                "chocolateType"));
        return chocolateCandy;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
    public static void main(String[] args) {
        CandiesDomBuilder domBuilder = new CandiesDomBuilder();
        domBuilder.buildSetCandies("C:\\Users\\zav\\IdeaProjects" +
                "\\prEpamJava\\task08XmlParsing\\src\\main\\resources\\data\\candy.xml");
////        System.out.println(domBuilder.getCandies());
        Set<Candy> candies=domBuilder.getCandies();
        for(Candy candy : candies){
            System.out.println(candy.toString());
        }
    }
}

