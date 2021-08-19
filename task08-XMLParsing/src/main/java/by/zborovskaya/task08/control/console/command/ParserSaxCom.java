package by.zborovskaya.task08.control.console.command;

import by.zborovskaya.task08.entity.Candy;
import by.zborovskaya.task08.servise.parser.CandiesSaxBuilder;

import java.util.Set;

public class ParserSaxCom implements Command{
    @Override
    public Set<Candy> execute(String pathXsd, String pathXml) {
        CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder(pathXsd);
        saxBuilder.buildSetCandies(pathXml);
        return saxBuilder.getCandies();
    }
}
