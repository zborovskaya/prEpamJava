package by.zborovskaya.task08.control.console.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
    public CommandProvider() {
        repository.put(CommandName.DOM_PARSER, new ParserDomCom());
        repository.put(CommandName.SAX_PARSER, new ParserSaxCom());
        repository.put(CommandName.STAX_PARSER,new ParserStaxCom());
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
