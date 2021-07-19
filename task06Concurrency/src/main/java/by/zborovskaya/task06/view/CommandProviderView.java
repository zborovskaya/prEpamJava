package by.zborovskaya.task06.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProviderView {
    private static final Logger logger = LogManager.getLogger( CommandProviderView.class);
    private final Map<Integer, String> repository = new HashMap<Integer, String>();
    public CommandProviderView() {
        repository.put(1, "FILL_WITH_LOCK");
        repository.put(2, "FILL_WITH_SEMAPHORE");
        repository.put(3,"FILL_WITH_CHANNELPOOL");
        repository.put(4, "FILL_WITH_PHASER");
        repository.put(5, "FILL_WITH_HASHMAP");
    }

    public String getCommand(Integer choice){
        String commandName =null;
        try{
            commandName = repository.get(choice);
        }catch(Exception e){
            logger.error("Request cannot be made");
        }
        return commandName;
    }
}
