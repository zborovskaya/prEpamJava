package by.zborovskaya.task04.control;

import by.zborovskaya.task04.service.ServiceFactory;
import by.zborovskaya.task04.service.TextService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestText implements Command{
    private static final Logger logger = LogManager.getLogger(RequestText.class);
    ServiceFactory objectFactory = ServiceFactory.getInstance();
    TextService textRealizationService = objectFactory.getTextRealizationService();

    /**
     * The method transfers the task RequestText to the server and receives the work result
     * @param head
     * @param textBody
     * @return Answer 1)Task completed successfully, if there are not errors
     *                2)Error
     */

    public String execute(String head, String textBody) {
        String response = null;
        try {
            textRealizationService.showText();
            response = "Reading completed successfully";
        } catch (Exception e) {
            logger.error(e.getMessage());
            response = "Error";
        }
        return response;
    }
}
