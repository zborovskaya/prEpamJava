package by.zborovskaya.task06.service.fillingDiagonal;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.FillingUsingMapCreator;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.exception.MatrixException;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.*;

public class MatrixFillingUsingMap {
    Map<Integer, Integer> map = new ConcurrentHashMap<Integer,Integer>();
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private FillingUsingMapCreator creator= new FillingUsingMapCreator();

    public SquareMatrix execute(String pathMatrix, String pathThreads){
        Map<Integer, Integer> map = new ConcurrentHashMap<Integer,Integer>();
        SquareMatrix matrix=creatorMatrix.create(pathMatrix);
        ArrayList<FillingUsingMap> list=creator.create(pathThreads, map, matrix.getSize());
        for(FillingUsingMap t:list){
            t.start();
        }
        for(FillingUsingMap t:list){
            try{
                t.join();
            }
            catch(InterruptedException e){

                System.out.printf("%s has been interrupted", t.getName());
            }
        }
        try {
            for(int i=0; i< matrix.getSize();i++) matrix.setElement(i,i,map.get(i));
        }catch (MatrixException ex){}
        return matrix;
    }
}
