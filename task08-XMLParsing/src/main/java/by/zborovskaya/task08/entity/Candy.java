package by.zborovskaya.task08.entity;

import java.util.Objects;

abstract public class Candy {
    private String name;
    private int energy;
    private String production;
    private ProductValue productValue;
    private String marking;
    private String dateProduction;
    private Ingredients ingredients;

    public Candy(String name, int energy, String production, String marking,
                 double proteins, double fats, double carbohydrates,String dateProduction,Ingredients ingredients) {
        this.name = name;
        this.energy = energy;
        this.production = production;
        this.productValue= new ProductValue(proteins,fats,carbohydrates);
        this.marking = marking;
        this.dateProduction=dateProduction;
        this.ingredients=ingredients;
    }
    public Candy(Ingredients ingredients){
        productValue=new ProductValue();
        this.ingredients=ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public String getName() {
        return name;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public int getEnergy() {
        return energy;
    }

    public String getProduction() {
        return production;
    }

    public ProductValue getProductValue() {
        return productValue;
    }

    public String getMarking() {
        return marking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setProductValue(ProductValue productValue) {
        this.productValue = productValue;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", dateProduction="+dateProduction+
                ", energy=" + energy +
                ", production='" + production + '\'' +
                ", productValue=" + productValue.toString() +
                ", marking='" + marking +
                "ingredient=" + ingredients.toString()+'\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;
        Candy candy = (Candy) o;
        return energy == candy.energy &&
                name.equals(candy.name) &&
                production.equals(candy.production) &&
                productValue.equals(candy.productValue) &&
                marking.equals(candy.marking) &&
                dateProduction.equals(candy.dateProduction)
                && ingredients.equals(candy.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, energy, production, productValue, marking, dateProduction, ingredients);
    }
}
