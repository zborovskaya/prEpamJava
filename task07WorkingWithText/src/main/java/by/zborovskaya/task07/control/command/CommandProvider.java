package by.zborovskaya.task07.control.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
    public CommandProvider() {
        repository.put(CommandName.SORTING_PARAGRAPHS, new SortingParagraphsCom());
        repository.put(CommandName.SORTING_LEXEMES, new SortingLexemesCom());
        repository.put(CommandName.SORTING_WORDS,new SortingWordsCom());
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
