package by.zborovskaya.task08.servise.parser;

import by.zborovskaya.task08.entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public class CandiesStaxBuilder extends CandiesBuilder {
    private XMLInputFactory inputFactory;
    public CandiesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void buildSetCandies(String filename) {
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(CandyXmlTag.CARAMELCANDY.getValue())) {
                        Candy candy = buildCaramelCandies(reader);
                        candies.add(candy);
                    }
                    if (name.equals(CandyXmlTag.CHOCOLATECANDY.getValue())) {
                        Candy candy = buildChocolateCandies(reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Candy  buildCaramelCandies(XMLStreamReader reader)
            throws XMLStreamException {
        CaramelCandy caramelCandy=new CaramelCandy();
        caramelCandy.setMarking(reader.getAttributeValue(null, CandyXmlTag.MARKING.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case NAME ->caramelCandy.setName(getXMLText(reader));
                        case DATEPRODUCTION ->caramelCandy.setDateProduction(getXMLText(reader));
                        case PRODUCTION->caramelCandy.setProduction(getXMLText(reader));
                        case ENERGY-> caramelCandy.setEnergy(Integer.parseInt(getXMLText(reader)));
                        case VALUE ->caramelCandy.setProductValue(getXMLValue(reader));
                        case INGREDIENTSCARAMEL -> caramelCandy.setIngredients(getXMLCaramelIngr(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyXmlTag.valueOf(name.toUpperCase()) == CandyXmlTag.CARAMELCANDY) {
                        return caramelCandy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <student>");
    }
    private Candy  buildChocolateCandies(XMLStreamReader reader)
            throws XMLStreamException {
        ChocolateCandy chocolateCandy=new ChocolateCandy();
        chocolateCandy.setMarking(reader.getAttributeValue(null, CandyXmlTag.MARKING.getValue()));
        String filling =reader.getAttributeValue(null, CandyXmlTag.FILLING.getValue());
        if(filling==null){
            chocolateCandy.setFilling("nothing");
        } else{
            chocolateCandy.setFilling(filling);
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case NAME ->chocolateCandy.setName(getXMLText(reader));
                        case DATEPRODUCTION ->chocolateCandy.setDateProduction(getXMLText(reader));
                        case PRODUCTION->chocolateCandy.setProduction(getXMLText(reader));
                        case ENERGY-> chocolateCandy.setEnergy(Integer.parseInt(getXMLText(reader)));
                        case VALUE ->chocolateCandy.setProductValue(getXMLValue(reader));
                        case INGREDIENTSCHOCOLATE ->  chocolateCandy.setIngredients(getXMLChocolateIngr(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyXmlTag.valueOf(name.toUpperCase()) == CandyXmlTag.CHOCOLATECANDY) {
                        return chocolateCandy;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <student>");
    }
    private ProductValue getXMLValue(XMLStreamReader reader)
            throws XMLStreamException {
        ProductValue productValue=new ProductValue();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case FATS ->productValue.setFats(Double.parseDouble(getXMLText(reader)));
                        case PROTEINS -> productValue.setProteins(Double.parseDouble(getXMLText(reader)));
                        case CARBOHYDRATES -> productValue.setCarbohydrates(Double.parseDouble(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyXmlTag.valueOf(name.toUpperCase()) == CandyXmlTag.VALUE) {
                        return productValue;

                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }
    private Ingredients getXMLChocolateIngr(XMLStreamReader reader)throws XMLStreamException {
        IngredientsChocolate ingredientsChocolate=new IngredientsChocolate();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case WATER ->ingredientsChocolate.setWater(Double.parseDouble(getXMLText(reader)));
                        case SUGAR -> ingredientsChocolate.setSugar(Double.parseDouble(getXMLText(reader)));
                        case FRUCTOSE -> ingredientsChocolate.setFructose(Double.parseDouble(getXMLText(reader)));
                        case VANILLIN -> ingredientsChocolate.setVanillin(Double.parseDouble(getXMLText(reader)));
                        case CHOCOLATETYPE -> ingredientsChocolate.setChocolateType(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyXmlTag.valueOf(name.toUpperCase()) == CandyXmlTag.INGREDIENTSCHOCOLATE) {
                        return ingredientsChocolate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }
    private Ingredients getXMLCaramelIngr(XMLStreamReader reader) throws XMLStreamException{
        IngredientsCaramel ingredientsCaramel=new IngredientsCaramel();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyXmlTag.valueOf(name.toUpperCase())) {
                        case WATER ->ingredientsCaramel.setWater(Double.parseDouble(getXMLText(reader)));
                        case SUGAR -> ingredientsCaramel.setSugar(Double.parseDouble(getXMLText(reader)));
                        case FRUCTOSE -> ingredientsCaramel.setFructose(Double.parseDouble(getXMLText(reader)));
                        case VANILLIN -> ingredientsCaramel.setVanillin(Double.parseDouble(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyXmlTag.valueOf(name.toUpperCase()) == CandyXmlTag.INGREDIENTSCARAMEL) {
                        return ingredientsCaramel;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
    public static void main(String[] args) {
        CandiesStaxBuilder staxBuilder = new CandiesStaxBuilder();
        staxBuilder.buildSetCandies("task08-XMLParsing/src/main/resources/data/candy.xml");
        Set<Candy> candies=staxBuilder.getCandies();
        for(Candy candy : candies){
            System.out.println(candy.toString());
        }
    }
}
