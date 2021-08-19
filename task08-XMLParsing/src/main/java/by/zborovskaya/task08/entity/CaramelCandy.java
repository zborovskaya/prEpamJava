package by.zborovskaya.task08.entity;

public class CaramelCandy extends Candy{

    public CaramelCandy(){
        super(new IngredientsCaramel());
    }

    public CaramelCandy(String name, int energy, String production, String marking, double proteins,
                        double fats, double carbohydrates, String dateProduction, Ingredients ingredients) {
        super(name, energy, production, marking, proteins, fats, carbohydrates, dateProduction, ingredients);
    }

    @Override
    public String toString() {
        return "CaramelCandy{" + super.toString()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
