package by.zborovskaya.task08.entity;

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
}
