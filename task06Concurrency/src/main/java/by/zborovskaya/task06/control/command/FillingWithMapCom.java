package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.fillingDiagonal.MatrixFillingUsingMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FillingWithMapCom implements Command {
    static final Logger logger = LogManager.getLogger(FillingWithMapCom.class);

    public SquareMatrix execute(String pathMatrix, String pathThread){
        SquareMatrix matrix=null;
        MatrixFillingUsingMap matrixFillingUsingMap=new MatrixFillingUsingMap();
        matrix=matrixFillingUsingMap.execute(pathMatrix,  pathThread);
        return matrix;
    }
}
