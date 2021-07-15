package by.zborovskaya.task06.control;

import by.zborovskaya.task06.entity.SquareMatrix;
import by.zborovskaya.task06.service.creator.DataCreatorThird;
import by.zborovskaya.task06.service.creator.MatrixCreatorFilling;
import by.zborovskaya.task06.service.fillingDiagonal.FillingDiagonalThird;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChannelPoolRunner {
    static final Logger logger = LogManager.getLogger(ChannelPoolRunner.class);
    private MatrixCreatorFilling creatorMatrix=new MatrixCreatorFilling();
    private DataCreatorThird creatorData= new DataCreatorThird();
    private final String PATH_OF_MATRIX="C:\\Users\\zav\\IdeaProjects\\prEpamJava" +
            "\\task06Concurrency\\data\\dataMatrix.txt";
    private final String PATH_OF_THREADS="C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency" +
            "\\data\\dataThreads.txt";

    public void execute(){
        SquareMatrix matrix=creatorMatrix.create(PATH_OF_MATRIX);
        ArrayList<Integer> arr= creatorData.create(PATH_OF_THREADS,matrix);
        int numberOfThreads= arr.size();
        CountDownLatch countDownLatch=new CountDownLatch(numberOfThreads);
        ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);
        int i=0;
            while( i < numberOfThreads) {
                threadPool.submit(new FillingDiagonalThird(arr.get(i),matrix,i, numberOfThreads,countDownLatch));
                i++;
            }
        threadPool.shutdown();
            try {
                countDownLatch.await();
            }catch (InterruptedException e){
                logger.error("Error in ChannelPoolRunner");
            }
        System.out.println(matrix.toString());
    }

}
