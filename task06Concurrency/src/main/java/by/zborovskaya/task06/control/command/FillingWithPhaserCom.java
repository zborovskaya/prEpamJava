package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorFourth;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalPhaser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class FillingWithPhaserCom implements Command{
    static final Logger logger = LogManager.getLogger(FillingWithPhaserCom.class);
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private ThreadsCreatorFourth creatorThread= new ThreadsCreatorFourth();

    public SquareMatrix execute(String pathMatrix, String pathThread){
        SquareMatrix matrix=creatorMatrix.create(pathMatrix);
        ArrayList<FillingDiagonalPhaser> list=creatorThread.create(pathThread, matrix);
        for(FillingDiagonalPhaser t:list){
            t.start();
        }
        for(FillingDiagonalPhaser t:list){
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
