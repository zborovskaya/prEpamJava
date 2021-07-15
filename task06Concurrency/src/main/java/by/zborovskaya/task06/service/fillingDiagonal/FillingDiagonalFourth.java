package by.zborovskaya.task06.service.fillingDiagonal;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.exception.MatrixException;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FillingDiagonalFourth extends Thread {
    final TimeUnit milliUnit = TimeUnit.MILLISECONDS;
    private int x;
    private SquareMatrix matrix;
    private ReentrantLock locker;
    private Phaser phaser;
    private  int numberOfPhases;

    public FillingDiagonalFourth(int x, ReentrantLock locker, SquareMatrix matrix, Phaser phaser,int numberOfPhases) {
        this.matrix = matrix;
        this.x = x;
        this.locker = locker;
        this.phaser = phaser;
        this.numberOfPhases=numberOfPhases;

    }

    public int getX() {
        return x;
    }

    /**
     * The function fills the diagonal of the matrix in the fourth way
     */

    public void run() {
        int sizeOfMatrix=matrix.getSize();
        int i=0;
        for(int number=0; number<numberOfPhases; number++){
//                System.out.println(Thread.currentThread().getName() + "start" + phaser.getPhase() + "Phase");
                try {
                    locker.lock();

                    while (matrix.getElement(i, i) != 0 && (i<sizeOfMatrix)) {
//                        System.out.println(Thread.currentThread().getName() +
//                                "i=" + i);
                        i++;
                    }
                    if(i<sizeOfMatrix) { matrix.setElement(i, i, x);
                        System.out.println(Thread.currentThread().getName() +
                                "устнавливает значение " + x + " на позицию" + i);}
                    locker.unlock();
//                    System.out.println("Phase " + phaser.getPhase() + " end");
                    phaser.arriveAndAwaitAdvance();
                } catch (MatrixException e) {
                }
        }
    }
}
