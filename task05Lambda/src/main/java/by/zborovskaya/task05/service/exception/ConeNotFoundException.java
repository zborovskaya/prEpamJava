package by.zborovskaya.task05.service.exception;

public class ConeNotFoundException extends  Exception {

    public  ConeNotFoundException(Exception e){
        super(e);
    }

    public  ConeNotFoundException(String message, Exception e){
        super(message, e);
    }

    public  ConeNotFoundException(String message){
        super(message);
    }

}
