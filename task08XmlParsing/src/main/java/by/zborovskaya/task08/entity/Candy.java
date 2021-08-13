package by.zborovskaya.task08.entity;

abstract public class Candy {
    private String name;
    private int energy;
    private String production;
    private ProductValue productValue;
    private String marking;
    private String dateProduction;

    public Candy(String name, int energy, String production, String marking,
                 double proteins, double fats, double carbohydrates,String dateProduction) {
        this.name = name;
        this.energy = energy;
        this.production = production;
        this.productValue= new ProductValue(proteins,fats,carbohydrates);
        this.marking = marking;
        this.dateProduction=dateProduction;
    }
    public Candy(){
        productValue=new ProductValue();
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
                ", marking='" + marking + '\'';
    }
}
