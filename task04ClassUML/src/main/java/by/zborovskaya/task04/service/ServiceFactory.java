package by.zborovskaya.task04.service;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final TextService textService = new TextRealizationService();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TextService getTextRealizationService() {
        return textService;
    }
}
