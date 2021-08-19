package by.zborovskaya.task08.servise.parser;

import by.zborovskaya.task08.entity.Candy;

import java.util.Set;

public class CandiesBuilderFactory {
    private enum TypeParser {
        SAX, STAX, DOM
    }
    private CandiesBuilderFactory() {
    }
    public static CandiesBuilder createCandiesBuilder(String typeParser,String xsdFile) {
        // insert parser name validation
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new CandiesDomBuilder(xsdFile);
            }
            case STAX -> {
                return new CandiesStaxBuilder();
            }
            case SAX -> {
                return new CandiesSaxBuilder(xsdFile);
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
    public static void main(String[] args) {
        String type = "dom";
        CandiesBuilder builder = CandiesBuilderFactory.createCandiesBuilder(type,"task08-XMLParsing/src/main/resources/data/candy.xsd");
        builder.buildSetCandies("task08-XMLParsing/src/main/resources/data/candy.xml");
        Set<Candy> candies=builder.getCandies();
        for(Candy candy : candies){
            System.out.println(candy.toString());
        }
    }
}
