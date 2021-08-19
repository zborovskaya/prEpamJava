package by.zborovskaya.task08.control.console.command;

import by.zborovskaya.task08.entity.Candy;

import java.util.Set;

public interface Command {
    Set<Candy> execute(String pathXsd, String pathXml);
}
