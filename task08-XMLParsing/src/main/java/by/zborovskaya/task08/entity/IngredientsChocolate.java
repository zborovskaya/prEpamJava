package by.zborovskaya.task08.entity;

import java.util.Objects;

public class IngredientsChocolate extends Ingredients {
    private String chocolateType;

    public IngredientsChocolate(double water, double sugar, double fructose, double vanillin,String chocolateType) {
        super(water,sugar,fructose, vanillin);
        this.chocolateType=chocolateType;
    }
    public IngredientsChocolate(){}

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    @Override
    public String toString() {
        return
                "IngredientsChocolate{"+ super.toString()+
                "chocolateType='" + chocolateType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientsChocolate)) return false;
        if (!super.equals(o)) return false;
        IngredientsChocolate that = (IngredientsChocolate) o;
        return chocolateType.equals(that.chocolateType) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chocolateType);
    }
}
