package by.training.task03.service.exception;

public class ServiceException extends Exception{
    public ServiceException() {
    }
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(Exception e){
        super(e);
    }
    public ServiceException(String message, Exception e){
        super(message, e);
    }

}
