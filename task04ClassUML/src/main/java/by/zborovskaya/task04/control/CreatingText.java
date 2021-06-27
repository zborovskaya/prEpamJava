package by.zborovskaya.task04.control;

import by.zborovskaya.task04.service.ServiceFactory;
import by.zborovskaya.task04.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatingText implements Command{
    private static final Logger logger = LogManager.getLogger(CreatingText.class);

    public String execute(String head, String textBody) {
        String response = null;
        try {
            ServiceFactory objectFactory = ServiceFactory.getInstance();
            TextService textRealizationService = objectFactory.getTextRealizationService();
            textRealizationService.createNewText(head,textBody);
            response = "Creating completed successfully";
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = "Error";
        }
        return response;
    }
}
