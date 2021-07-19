package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorFirst;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FillingWithLockCom implements Command{
    static final Logger logger = LogManager.getLogger(FillingWithLockCom.class);
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private ThreadsCreatorFirst creatorThread= new ThreadsCreatorFirst();

    public SquareMatrix execute(String pathMatrix, String pathThread){
        SquareMatrix matrix=creatorMatrix.create(pathMatrix);
        ArrayList<FillingDiagonalLock> list=creatorThread.create(pathThread, matrix);
        for(FillingDiagonalLock t:list){
            t.start();
        }
        for(FillingDiagonalLock t:list){
            try{
                t.join();
            }
            catch(InterruptedException e){
                logger.error("Error.Has been interrupted ", t.getName());
            }
        }
        return matrix;
    }
}
