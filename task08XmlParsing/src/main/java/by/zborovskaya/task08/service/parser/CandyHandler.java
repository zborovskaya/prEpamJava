package by.zborovskaya.task08.service.parser;

import by.zborovskaya.task08.entity.Candy;
import by.zborovskaya.task08.entity.CaramelCandy;
import by.zborovskaya.task08.entity.ChocolateCandy;
import by.zborovskaya.task08.entity.ProductValue;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
//    private Set<Candy> candies;
//    private Candy current;
//    private CandyXmlTag currentXmlTag;
//    private EnumSet<CandyXmlTag> withText;
//    private static final String ELEMENT_CHOCOLATE_CANDY = "chocolateCandy";
//    private static final String ELEMENT_CARAMEL_CANDY = "caramelCandy";
//    public CandyHandler() {
//        candies= new HashSet<Candy>();
//        withText = EnumSet.range(CandyXmlTag.NAME, CandyXmlTag.CHOCOLATE_TYPE);
//    }
//    public Set<Candy> getCandies() {
//        return candies;
//    }
//    public void startElement(String uri, String localName, String qName, Attributes attrs) {
//        if (ELEMENT_CARAMEL_CANDY.equals(qName)) {
//            current = new CaramelCandy();
//            current.setMarking(attrs.getValue("marking"));
//
//        }
//        if(ELEMENT_CHOCOLATE_CANDY.equals(qName)){
//            current = new ChocolateCandy();
//            current.setMarking(attrs.getValue("marking"));
//
//        }else {
//            CandyXmlTag temp = CandyXmlTag.valueOf(qName.toUpperCase());
//            if (withText.contains(temp)) {
//                currentXmlTag = temp;
//            }
//        }
//    }
//    public void endElement(String uri, String localName, String qName) {
//        if ((ELEMENT_CARAMEL_CANDY.equals(qName))){
//            candies.add(current);
//        }
//        if ((ELEMENT_CHOCOLATE_CANDY.equals(qName))){
//            candies.add(current);
//        }
//    }
//    public void characters(char[] ch, int start, int length) {
//        String data = new String(ch, start, length).strip();
//        ProductValue productValue=current.getProductValue();
//        if (currentXmlTag!= null) {
//            switch (currentXmlTag) {
//                case NAME -> current.setName(data);
//                case ENERGY -> current.setEnergy(Integer.parseInt(data));
//                case FATS ->current.set
//                case STREET -> current.getAddress().setStreet(data);
//                case CITY -> current.getAddress().setCity(data);
//                case COUNTRY -> current.getAddress().setCountry(data);
//                ENERGY("energy"),
//                        PRODUCTION("production"),
//                        DATE_PRODUCTION("dateProduction"),
//                        PROTEINS("proteins"),
//                        FATS("fats"),
//                        CARBOHYDRATES("carbohydrates"),
//                        WATER("water"),
//                        SUGAR("sugar"),
//                        FRUCTOSE("fructose"),
//                        VANILLIN("vanillin"),
//                        CHOCOLATE_TYPE("chocolateType"),
//                default -> throw new EnumConstantNotPresentException(
//                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
//            }
//        }
//        currentXmlTag = null;
//    }
}
