package by.zborovskaya.task05.service.exception;

public class InputException extends Exception {
    public InputException(Exception e){
        super(e);
    }

    public InputException(String message, Exception e){
        super(message, e);
    }
    public InputException(String message){
        super(message);
    }
}
