package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;

public interface Command {
    SquareMatrix execute(String pathMatrix, String pathThread);
}
