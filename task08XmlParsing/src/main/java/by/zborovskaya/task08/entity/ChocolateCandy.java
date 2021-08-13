package by.zborovskaya.task08.entity;

public class ChocolateCandy extends Candy{
    private IngredientsChocolate ingredientsChocolate;
    private String filling;

    public ChocolateCandy(String name, int energy, String production, String marking,
                          double proteins, double fats, double carbohydrates,
                          double water, double sugar, double fructose,
                          double vanillin,String chocolateType,String filling,String dateProduction) {
        super(name,energy,production,marking, proteins,fats,carbohydrates,dateProduction);
        ingredientsChocolate=new IngredientsChocolate(water, sugar, fructose, vanillin,chocolateType);
        this.filling=filling;
    }
    public ChocolateCandy(){
        this.ingredientsChocolate=new IngredientsChocolate();
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public IngredientsChocolate getIngredientsChocolate() {
        return ingredientsChocolate;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +super.toString()+
                "ingredientsChocolate=" + ingredientsChocolate.toString() +
                ", filling='" + filling + '\'' +
                '}';
    }
}
