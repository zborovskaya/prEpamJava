package by.zborovskaya.task05.dao.exception;

import java.io.IOException;

public class DAOException extends IOException {
    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }
}
