package by.zborovskaya.task08.servise.parser;

import by.zborovskaya.task08.entity.*;
import by.zborovskaya.task08.servise.parser.CandiesSaxBuilder;
import by.zborovskaya.task08.servise.parser.CandyXmlTag;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current;
    private CandyXmlTag currentXmlTag;
    private EnumSet<CandyXmlTag> withText;
    private static final String ELEMENT_CHOCOLATE_CANDY = "chocolateCandy";
    private static final String ELEMENT_CARAMEL_CANDY = "caramelCandy";
    public CandyHandler() {
        candies= new HashSet<Candy>();
        withText = EnumSet.range(CandyXmlTag.NAME, CandyXmlTag.CHOCOLATETYPE);
    }
    public CandyHandler(Set<Candy> candies) {
        this.candies=candies;
        withText = EnumSet.range(CandyXmlTag.NAME, CandyXmlTag.CHOCOLATETYPE);
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_CARAMEL_CANDY.equals(qName)) {
            current = new CaramelCandy();
            current.setMarking(attrs.getValue("marking"));

        }
        if(ELEMENT_CHOCOLATE_CANDY.equals(qName)){
            current = new ChocolateCandy();
            current.setMarking(attrs.getValue("marking"));
            ChocolateCandy currentChocolate=(ChocolateCandy) current;
            currentChocolate.setFilling(attrs.getValue("filling"));

        }else {
            CandyXmlTag temp = CandyXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ((ELEMENT_CARAMEL_CANDY.equals(qName))){
            candies.add(current);
        }
        if ((ELEMENT_CHOCOLATE_CANDY.equals(qName))){
            candies.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case ENERGY -> current.setEnergy(Integer.parseInt(data));
                case FATS ->current.getProductValue().setFats(Double.parseDouble(data));
                case CARBOHYDRATES ->current.getProductValue().setCarbohydrates(Double.parseDouble(data));
                case PROTEINS ->current.getProductValue().setProteins(Double.parseDouble(data));
                case PRODUCTION -> current.setProduction(data);
                case DATEPRODUCTION -> current.setDateProduction(data);
                case WATER ->current.getIngredients().setWater(Double.parseDouble(data));
                case SUGAR -> current.getIngredients().setSugar(Double.parseDouble(data));
                case FRUCTOSE -> current.getIngredients().setFructose(Double.parseDouble(data));
                case VANILLIN -> current.getIngredients().setVanillin(Double.parseDouble(data));
                case CHOCOLATETYPE -> {Ingredients ingredients=current.getIngredients();
                IngredientsChocolate ingredientsChocolate=(IngredientsChocolate) ingredients;
                ((IngredientsChocolate) ingredients).setChocolateType(data);
                }
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
    public static void main(String[] args) {
        CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder("task08-XMLParsing/src/main/resources/data/candy.xsd");
        saxBuilder.buildSetCandies("task08-XMLParsing/src/main/resources/data/candy.xml");
        Set <Candy> candies=saxBuilder.getCandies();
        for(Candy candy : candies){
            System.out.println(candy.toString());
        }
    }
}
