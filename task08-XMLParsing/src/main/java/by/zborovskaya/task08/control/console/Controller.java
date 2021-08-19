package by.zborovskaya.task08.control.console;

import by.zborovskaya.task08.control.console.command.Command;
import by.zborovskaya.task08.control.console.command.CommandProvider;
import by.zborovskaya.task08.entity.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final CommandProvider provider = new CommandProvider();

    /**
     * Function executes one of the commands
     * @param request command's name, pathXsd - path xsd file,pathXml-path xml file
     * @return
     */

    public Set<Candy> executeTask(String request, String pathXsd, String pathXml){
        Command executionCommand;
        executionCommand = provider.getCommand(request);
        return executionCommand.execute(pathXsd,pathXml);
    }
}
