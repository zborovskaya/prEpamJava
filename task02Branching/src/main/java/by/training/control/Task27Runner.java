package by.training.control;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.training.service.*;

/**
 * Class execute Task 27
 */

public class Task27Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void execute(){
        Scanner scan = new Scanner(System.in);

        logger.info("User chose Task 27");

        System.out.println("Enter a and press <Enter> &  b and press <Enter> & c and press <Enter> & d and press <Enter>:");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double d = scan.nextDouble();
        Task27 task27= new Task27();
        System.out.println("max{min(a, b), min(c, d)} = "+task27.findMaxAmongMin(a,b,c,d));
        logger.info("Function completed successfully");
    }
}
