package by.zborovskaya.task08.entity;

import java.util.Objects;

public abstract class Ingredients {
    private double water;
    private double sugar;
    private double fructose;
    private double vanillin;

    public Ingredients(double water, double sugar, double fructose, double vanillin) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.vanillin = vanillin;
    }
    public Ingredients(){
    }

    public double getWater() {
        return water;
    }

    public double getSugar() {
        return sugar;
    }

    public double getFructose() {
        return fructose;
    }

    public double getVanillin() {
        return vanillin;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public void setFructose(double fructose) {
        this.fructose = fructose;
    }

    public void setVanillin(double vanillin) {
        this.vanillin = vanillin;
    }

    @Override
    public String toString() {
        return "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", vanillin=" + vanillin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredients)) return false;
        Ingredients that = (Ingredients) o;
        return Double.compare(that.water, water) == 0
                && Double.compare(that.sugar, sugar) == 0
                && Double.compare(that.fructose, fructose) == 0
                && Double.compare(that.vanillin, vanillin) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(water, sugar, fructose, vanillin);
    }
}
