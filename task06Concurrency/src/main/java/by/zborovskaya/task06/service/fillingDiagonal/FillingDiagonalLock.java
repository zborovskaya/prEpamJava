package by.zborovskaya.task06.service.fillingDiagonal;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.exception.MatrixException;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FillingDiagonalLock extends Thread{
    final TimeUnit milliUnit = TimeUnit.MILLISECONDS;
    private int x;
    private SquareMatrix matrix;
    ReentrantLock locker;

    public FillingDiagonalLock(int x, ReentrantLock locker, SquareMatrix matrix) {
        this.matrix=matrix;
        this.x = x;
        this.locker = locker;
    }

    public int getX() {
        return x;
    }

    /**
     * The function fills the diagonal of the matrix in the first way
     */

    public void run() {
        try {

            for (int i = 0; i < matrix.getSize(); i++) {
                locker.lock();
                if (matrix.getElement(i, i) == 0) {
                    matrix.setElement(i,i,x);
//                    System.out.println(Thread.currentThread().getName()+"устнавливает значение "+x+" на позицию"+i);
                    milliUnit.sleep(25);
                }
                locker.unlock();
                milliUnit.sleep(25);
            }
        }catch (MatrixException e){}
        catch(InterruptedException ex){
            locker.unlock();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FillingDiagonalLock)) return false;
        FillingDiagonalLock that = (FillingDiagonalLock) o;
        return x == that.x &&
                Objects.equals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, matrix);
    }

    @Override
    public String toString() {
        return "FillingDiagonalFirst{" +
                "x=" + x +
                ", matrix=" + matrix +
                ", locker=" + locker +
                '}';
    }
}
