package by.zborovskaya.task08.entity;

import java.util.Objects;

public class ChocolateCandy extends Candy{
    private String filling;

    public ChocolateCandy(String name, int energy, String production, String marking,
                          double proteins, double fats, double carbohydrates,
                          String dateProduction, Ingredients ingredients, String filling) {
        super(name, energy, production, marking, proteins, fats, carbohydrates, dateProduction, ingredients);
        this.filling = filling;
    }

    public ChocolateCandy(){
        super(new IngredientsChocolate());
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +super.toString()+
                ", filling='" + filling + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChocolateCandy)) return false;
        if (!super.equals(o)) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return Objects.equals(filling, that.filling);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filling);
    }
}
