package by.zborovskaya.task06.control.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);
    private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
    public CommandProvider() {
        repository.put(CommandName.FILL_WITH_LOCK, new FillingWithLockCom());
        repository.put(CommandName.FILL_WITH_SEMAPHORE, new FillingWithSemCom());
        repository.put(CommandName.FILL_WITH_CHANNELPOOL,new ChannelPoolCom());
        repository.put(CommandName.FILL_WITH_PHASER, new FillingWithPhaserCom());
        repository.put(CommandName.FILL_WITH_HASHMAP, new FillingWithMapCom());
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
