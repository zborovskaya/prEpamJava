package by.zborovskaya.task08.entity;

public class CaramelCandy extends Candy{
    private Ingredients ingredientsCaramel;

    public CaramelCandy(String name, int energy, String production, String marking,
                          double proteins, double fats, double carbohydrates,double water,
                        double sugar, double fructose, double vanillin,String dateProduction) {
        super(name,energy,production,marking, proteins,fats,carbohydrates,dateProduction);
        ingredientsCaramel =new IngredientsCaramel( water,sugar,fructose,vanillin);
    }

    public CaramelCandy(){
        ingredientsCaramel =new IngredientsCaramel();
    }

    public Ingredients getIngredientsCaramel() {
        return ingredientsCaramel;
    }

    @Override
    public String toString() {
        return "CaramelCandy{" + super.toString()+
                "ingredientCaramel=" + ingredientsCaramel.toString() +
                '}';
    }
}
