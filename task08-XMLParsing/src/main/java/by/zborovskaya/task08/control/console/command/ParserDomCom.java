package by.zborovskaya.task08.control.console.command;

import by.zborovskaya.task08.entity.Candy;
import by.zborovskaya.task08.servise.parser.CandiesDomBuilder;

import java.util.Set;

public class ParserDomCom implements Command{
    @Override
    public Set<Candy> execute(String pathXsd,String pathXml) {
        CandiesDomBuilder domBuilder = new CandiesDomBuilder(pathXsd);
        domBuilder.buildSetCandies(pathXml);
        return domBuilder.getCandies();
    }
}
