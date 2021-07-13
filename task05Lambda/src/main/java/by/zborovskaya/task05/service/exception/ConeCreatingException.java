package by.zborovskaya.task05.service.exception;

public class ConeCreatingException extends Exception{
    public ConeCreatingException(String message) {
        super(message);
    }

    public ConeCreatingException(String message, Exception e) {
        super(message, e);
    }

    public ConeCreatingException(Exception e) {
        super(e);
    }
}
