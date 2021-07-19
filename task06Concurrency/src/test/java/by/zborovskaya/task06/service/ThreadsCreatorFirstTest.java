package by.zborovskaya.task06.service;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.creator.ThreadsCreatorFirst;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalLock;
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
        ArrayList<FillingDiagonalLock> result=creatorThread
                .create("C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency\\data\\dataThreads.txt",
                        matrix);
        ArrayList<FillingDiagonalLock> answer= new ArrayList<>();
        int arr[]=new int[]{11,12,13,14};
        for(int i=0; i< arr.length; i++){
            answer.add(i,new FillingDiagonalLock(arr[i], locker, matrix));
        }
        Assert.assertEquals(result, answer);
    }
}