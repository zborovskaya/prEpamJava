package by.zborovskaya.task04.control;

import by.zborovskaya.task04.service.ServiceFactory;
import by.zborovskaya.task04.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddingText implements Command{
    private static final Logger logger = LogManager.getLogger(AddingText.class);

    public String execute(String headline, String textBody) {
        String response = null;
        try {
            ServiceFactory objectFactory = ServiceFactory.getInstance();
            TextService textRealizationService = objectFactory.getTextRealizationService();
            textRealizationService.addText(textBody);
            response = "Adding completed successfully";
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = "Error";
        }
        return response;
    }
}
