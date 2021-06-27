package by.zborovskaya.task04.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
    public CommandProvider() {
        repository.put(CommandName. CREATE_TEXT, new CreatingText());
        repository.put(CommandName.ADD_DATA, new AddingText());
        repository.put(CommandName. READ_TEXT, new RequestText());
        repository.put(CommandName. CLEAR_TEXT, new ClearingText());
        repository.put(CommandName.READ_HEADLINE, new RequestHeadline());
    }

    public Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(Exception e){
            logger.error("Request cannot be made");
        }
        return command;
    }
}
