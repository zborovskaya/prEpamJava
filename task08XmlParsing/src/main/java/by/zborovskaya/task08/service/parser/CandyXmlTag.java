package by.zborovskaya.task08.service.parser;

public enum CandyXmlTag {
    CANDIES("candies"),
    MARKING("marking"),
    FILLING("filling"),
    CANDY("candy"),
    NAME("name"),
    ENERGY("energy"),
    PRODUCTION("production"),
    DATE_PRODUCTION("dateProduction"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLIN("vanillin"),
    CHOCOLATE_TYPE("chocolateType"),
    VALUE("value"),
    INGREDIENTS_CHOCOLATE("ingredientsChocolate");
    private String value;
    CandyXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
