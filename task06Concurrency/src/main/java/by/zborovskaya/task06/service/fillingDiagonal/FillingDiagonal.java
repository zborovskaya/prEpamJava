package by.zborovskaya.task06.service.fillingDiagonal;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.exception.MatrixException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class FillingDiagonal implements Runnable{
    private final TimeUnit milliUnit = TimeUnit.MILLISECONDS;
    private int x;
    private SquareMatrix matrix;
    private int index;
    private int numberOfThreads;
    private CountDownLatch countDownLatch;

    public FillingDiagonal(int x, SquareMatrix matrix, int index, int numberOfThreads, CountDownLatch countDownLatch) {
        this.matrix=matrix;
        this.x = x;
        this.index=index;
        this.numberOfThreads=numberOfThreads;
        this.countDownLatch=countDownLatch;
    }

    public int getX() {
        return x;
    }

    /**
     * The function fills the diagonal of the matrix in the third way
     */

    public void run() {
        try {
            while(index<matrix.getSize()) {
                matrix.setElement(index, index, x);
//                System.out.println(Thread.currentThread().getName()+"устнавливает значение "+x+" на позицию"+index);
                index+=numberOfThreads;
            }
            countDownLatch.countDown();
        }catch (MatrixException e){}
    }
}
