package by.zborovskaya.task06.control;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorFourth;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalFourth;

import java.util.ArrayList;

public class FourthWayRunner {
    private final String PATH_OF_MATRIX="C:\\Users\\zav\\IdeaProjects\\prEpamJava" +
            "\\task06Concurrency\\data\\dataMatrix.txt";
    private final String PATH_OF_THREADS="C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency" +
            "\\data\\dataThreads.txt";
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private ThreadsCreatorFourth creatorThread= new ThreadsCreatorFourth();

    public void execute(){
        SquareMatrix matrix=creatorMatrix.create(PATH_OF_MATRIX);
        ArrayList<FillingDiagonalFourth> list=creatorThread.create(PATH_OF_THREADS, matrix);
        for(FillingDiagonalFourth t:list){
            t.start();
        }
        for(FillingDiagonalFourth t:list){
            try{
                t.join();
            }
            catch(InterruptedException e){

                System.out.printf("%s has been interrupted", t.getName());
            }
        }
        System.out.println(matrix.toString());

    }
}
