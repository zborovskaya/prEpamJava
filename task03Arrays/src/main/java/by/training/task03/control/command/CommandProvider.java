package by.training.task03.control.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
   public CommandProvider() {
        repository.put(CommandName.BUBBLE_SORTING, new BubbleSorting());
        repository.put(CommandName.INSERTION_SORTING, new InsertionSorting());
        repository.put(CommandName.MERGE_SORTING, new MergeSorting());
        repository.put(CommandName.SELECTION_SORTING, new SelectionSorting());
        repository.put(CommandName.SHAKER_SORTING, new ShakerSorting());
        repository.put(CommandName.SHELL_SORTING, new ShellSorting());
       repository.put(CommandName.WRONG_REQUEST, new Wrong_Request());
    }

    public Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(Exception e){
            logger.error("Request cannot be made");
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
