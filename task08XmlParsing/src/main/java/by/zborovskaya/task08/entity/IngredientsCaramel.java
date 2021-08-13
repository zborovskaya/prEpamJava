package by.zborovskaya.task08.entity;

public class IngredientsCaramel extends Ingredients {
    public IngredientsCaramel(double water, double sugar, double fructose, double vanillin) {
        super(water,sugar,fructose, vanillin);
    }

    public IngredientsCaramel(){}

    @Override
    public String toString() {
        return "IngredientsCaramel{"+super.toString()+
                '}';
    }
}
