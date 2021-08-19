package by.zborovskaya.task08.servise.parser;

import by.zborovskaya.task08.entity.Candy;

import java.util.HashSet;
import java.util.Set;

abstract public class CandiesBuilder {
    // protected - it is often accessed from a subclass
    protected Set<Candy> candies;
    public CandiesBuilder() {
        candies = new HashSet<Candy>();
    }
    public CandiesBuilder(Set<Candy> candies) {
        this.candies = candies;
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public abstract void buildSetCandies(String filename);
}
