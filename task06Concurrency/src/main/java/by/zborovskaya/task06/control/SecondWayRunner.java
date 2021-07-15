package by.zborovskaya.task06.control;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorSecond;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalSecond;

import java.util.ArrayList;

public class SecondWayRunner {
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private ThreadsCreatorSecond creatorThread= new  ThreadsCreatorSecond();
    private final String PATH_OF_MATRIX="C:\\Users\\zav\\IdeaProjects\\prEpamJava" +
            "\\task06Concurrency\\data\\dataMatrix.txt";
    private final String PATH_OF_THREADS="C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency" +
            "\\data\\dataThreads.txt";

    public void execute(){
        SquareMatrix matrix=creatorMatrix
                .create(PATH_OF_MATRIX);
        ArrayList<FillingDiagonalSecond> list=creatorThread
                .create(PATH_OF_THREADS, matrix);
        for(FillingDiagonalSecond t:list){
            t.start();
        }

        for(FillingDiagonalSecond t:list){
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
