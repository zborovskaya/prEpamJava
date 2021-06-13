package by.training.control;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.*;

/**
 * Class execute Task 35
 */

public class Task35Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void execute(){
        Scanner scan = new Scanner(System.in);

        try {
            logger.info("User chose Task 35");
            System.out.println("Enter day and press <Enter>:");
            int day = scan.nextInt();
            Task35 task35 = new Task35();
            int date[] = task35.findDate(day);
            if (date == null) throw new Exception();
            System.out.println("Date: " + date[0] + "." + date[1]);
            logger.info("Function completed successfully");
        }

        catch (Exception ex){
            System.out.println("There is not day");
        }
    }
}
