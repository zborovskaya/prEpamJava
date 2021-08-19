package by.zborovskaya.task08.control.console.command;

import by.zborovskaya.task08.entity.Candy;
import by.zborovskaya.task08.servise.parser.CandiesStaxBuilder;

import java.util.Set;

public class ParserStaxCom implements Command{
    @Override
    public Set<Candy> execute(String pathXsd, String pathXml) {
        CandiesStaxBuilder staxBuilder = new CandiesStaxBuilder();
        staxBuilder.buildSetCandies(pathXml);
        return staxBuilder.getCandies();
    }
}
