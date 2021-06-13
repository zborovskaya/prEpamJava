package by.training.control;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.training.service.*;

/**
 * Class execute Task 3
 */

public class Task3Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void execute(){
        Scanner scan = new Scanner(System.in);
        logger.info("User chose Task 3");
        System.out.println("Enter a and press <Enter>");
        double a = scan.nextDouble();
        Task3 task3= new Task3();
        System.out.println(task3.compare(a));
        logger.info("Function completed successfully");
    }

}
