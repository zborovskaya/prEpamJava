package by.zborovskaya.task06.service;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorFirst;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalFirst;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsCreatorFirstTest {
    ThreadsCreatorFirst creatorThread= new ThreadsCreatorFirst();
    MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();

    @Test
    public void testCreate() {
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        SquareMatrix matrix=creatorMatrix
                .create("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataMatrix.txt");
        ArrayList<FillingDiagonalFirst> result=creatorThread
                .create("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataThreads.txt",
                        matrix);
        ArrayList<FillingDiagonalFirst> answer= new ArrayList<>();
        int arr[]=new int[]{10,11,12,13,14,15};
        for(int i=0; i< arr.length; i++){
            answer.add(i,new FillingDiagonalFirst(arr[i], locker, matrix));
        }
        Assert.assertEquals(result, answer);
    }
}