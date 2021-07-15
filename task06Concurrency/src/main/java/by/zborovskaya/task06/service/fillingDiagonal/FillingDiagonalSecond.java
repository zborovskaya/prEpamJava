package by.zborovskaya.task06.service.fillingDiagonal;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.exception.MatrixException;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class FillingDiagonalSecond extends Thread{
    final TimeUnit milliUnit = TimeUnit.MILLISECONDS;
    private int x;
    private SquareMatrix matrix;
    Semaphore sem;

    public FillingDiagonalSecond(int x, Semaphore sem, SquareMatrix matrix) {
        this.matrix=matrix;
        this.x = x;
        this.sem=sem;
    }

    public int getX() {
        return x;
    }

    /**
     * The function fills the diagonal of the matrix in the second way
     */

    public void run() {
        try {

            for (int i = 0; i < matrix.getSize(); i++) {
                System.out.println(Thread.currentThread().getName() + " ожидает разрешение");
                sem.acquire();
                if (matrix.getElement(i, i) == 0) {
                    matrix.setElement(i,i,x);
                    System.out.println(Thread.currentThread().getName()+"устнавливает значение "+x+" на позицию "+i);
                    milliUnit.sleep(50);
                }
                sem.release();
            }

        }catch (MatrixException e){}
        catch(InterruptedException ex){
            sem.release();
            System.out.println(ex.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " освобождает разрешение");

    }
}
