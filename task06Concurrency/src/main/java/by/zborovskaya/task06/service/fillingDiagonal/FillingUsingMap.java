package by.zborovskaya.task06.service.fillingDiagonal;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FillingUsingMap extends Thread {
    private final TimeUnit milliUnit = TimeUnit.MILLISECONDS;
    private Map<Integer, Integer> map;
    private int x;
    private int matrixSize;
    ReentrantLock locker;

    public FillingUsingMap(int x,Map<Integer, Integer> map,int matrixSize,ReentrantLock locker){
        this.map=map;
        this.x=x;
        this.matrixSize=matrixSize;
        this.locker=locker;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < matrixSize; i++) {
                locker.lock();
                if (!map.containsKey(i)) {
                    map.put(i, x);
//                    System.out.println(Thread.currentThread().getName() + "устнавливает значение " + x +
//                            " на позицию" + i);
                    milliUnit.sleep(25);
                }
                locker.unlock();
            }
        }catch (InterruptedException ex){}
    }
}
