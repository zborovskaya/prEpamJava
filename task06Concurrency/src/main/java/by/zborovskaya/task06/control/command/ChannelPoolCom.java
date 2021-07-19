package by.zborovskaya.task06.control.command;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.DataCreatorThird;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChannelPoolCom implements Command {
    static final Logger logger = LogManager.getLogger(ChannelPoolCom.class);
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private DataCreatorThird creatorData= new DataCreatorThird();

    public SquareMatrix execute(String pathMatrix, String pathThread){
        SquareMatrix matrix=creatorMatrix.create(pathMatrix);
        ArrayList<Integer> arr= creatorData.create(pathThread,matrix);
        int numberOfThreads= arr.size();
        CountDownLatch countDownLatch=new CountDownLatch(numberOfThreads);
        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);
        int i=0;
            while( i < numberOfThreads) {
                threadPool.submit(new FillingDiagonal(arr.get(i),matrix,i, numberOfThreads,countDownLatch));
                i++;
            }
        threadPool.shutdown();
            try {
                countDownLatch.await();
            }catch (InterruptedException e){
                logger.error("Error in ChannelPoolRunner");
            }
            return matrix;
    }
}
