package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final CommandProvider provider = new CommandProvider();

    /**
     * Function executes one of the commands
     * @param request command's name
     * @return
     */

    public SquareMatrix executeTask(String request,String pathMatrix, String pathThread ){
        SquareMatrix matrix=null;
        Command executionCommand;
        executionCommand = provider.getCommand(request);
        String response;
        matrix = executionCommand.execute(pathMatrix,pathThread);
        return matrix;
    }
}
