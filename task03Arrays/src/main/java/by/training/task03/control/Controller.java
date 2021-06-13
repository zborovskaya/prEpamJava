package by.training.task03.control;

import by.training.task03.control.command.Command;
import by.training.task03.control.command.CommandProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Controller {
    private static final Logger logger = LogManager.getLogger(Controller.class);
    private final CommandProvider provider = new CommandProvider();

    /**
     * Function executes one of the commands
     * @param request command's name
     * @return 1)Sorting completed successfully
     *         2)Error in performing sorting
     */

    public String executeTask(String request, boolean order){
        Command executionCommand;
        executionCommand = provider.getCommand(request);
        String response;
        response = executionCommand.execute(order);
        logger.info(response);
        return response;
    }
}
