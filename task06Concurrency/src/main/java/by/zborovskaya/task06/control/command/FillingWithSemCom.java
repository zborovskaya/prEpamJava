package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorSecond;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalSem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FillingWithSemCom implements Command{
    static final Logger logger = LogManager.getLogger(FillingWithSemCom.class);
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private ThreadsCreatorSecond creatorThread= new  ThreadsCreatorSecond();

    public SquareMatrix execute(String pathMatrix, String pathThread){
        SquareMatrix matrix=creatorMatrix.create(pathMatrix);
        ArrayList<FillingDiagonalSem> list=creatorThread.create(pathThread, matrix);
        for(FillingDiagonalSem t:list){
            t.start();
        }
        for(FillingDiagonalSem t:list){
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
