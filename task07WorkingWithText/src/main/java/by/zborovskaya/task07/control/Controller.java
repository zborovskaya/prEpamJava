package by.zborovskaya.task07.control;

import by.zborovskaya.task07.control.command.Command;
import by.zborovskaya.task07.control.command.CommandProvider;
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

    public String executeTask(String request,String path){
        Command executionCommand;
        executionCommand = provider.getCommand(request);
        return executionCommand.execute(path);
    }
}
