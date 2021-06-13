package by.training.control;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.*;

/**
 * Class execute Task 19
 */

public class Task19Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void execute(){
        Scanner scan = new Scanner(System.in);

        logger.info("User chose Task 19");

        System.out.println("Enter a and press <Enter> &  b and press <Enter> & c and press <Enter> :");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        Task19 task19 = new Task19();
        System.out.println("Amount of positive numbers is " +task19.calculate(a,b,c));
        logger.info("Function completed successfully");
    }
}
