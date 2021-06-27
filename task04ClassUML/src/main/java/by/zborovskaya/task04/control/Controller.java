package by.zborovskaya.task04.control;

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

    public void executeTask(String request,String head, String TextBody ){
        Command executionCommand;
        executionCommand = provider.getCommand(request);
        String response;
        response = executionCommand.execute(head,TextBody);
        logger.info(response);
    }
}
