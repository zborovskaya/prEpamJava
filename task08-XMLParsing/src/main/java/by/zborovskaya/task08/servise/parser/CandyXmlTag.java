package by.zborovskaya.task08.servise.parser;

public enum CandyXmlTag {
    CANDIES("candies"),
    MARKING("marking"),
    FILLING("filling"),
    CHOCOLATECANDY("chocolateCandy"),
    CARAMELCANDY("caramelCandy"),
    NAME("name"),
    ENERGY("energy"),
    PRODUCTION("production"),
    DATEPRODUCTION("dateProduction"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLIN("vanillin"),
    CHOCOLATETYPE("chocolateType"),
    VALUE("value"),
    INGREDIENTSCHOCOLATE("ingredientsChocolate"),
    INGREDIENTSCARAMEL("ingredientsCaramel");
    private String value;
    CandyXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
