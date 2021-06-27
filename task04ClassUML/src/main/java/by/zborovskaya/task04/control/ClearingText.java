package by.zborovskaya.task04.control;

import by.zborovskaya.task04.service.ServiceFactory;
import by.zborovskaya.task04.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClearingText implements Command{
    private static final Logger logger = LogManager.getLogger(ClearingText.class);

    ServiceFactory objectFactory = ServiceFactory.getInstance();
    TextService textRealizationService = objectFactory.getTextRealizationService();
    /**
     * The method transfers the task ClearingText to the server and receives the work result
     * @param headline
     * @param textBody
     * @return Answer 1)Clearing completed successfully, if there are not errors
     *                2)Error
     */
    public String execute(String headline, String textBody) {
        String response = null;
        try {
            textRealizationService.clearText();
            response = "Clearing completed successfully";
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = "Error";
        }
        return response;
    }
}
