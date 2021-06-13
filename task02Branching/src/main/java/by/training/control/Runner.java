package by.training.control;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Zborovskaya Anna
 * Class {@code Runner} starts tasks
 *
 */

public class Runner {

    // Logger instance named "Runner".

    private static final Logger logger = LogManager.getLogger(Runner.class);

    /**
     *function {@link Runner#showMenu()}shows menu
     */

    public static void showMenu() {
        System.out.println("Menu: \n"
                +"1) Task 3\n"
                +"2) Task 11\n"
                +"3) Task 19\n"
                +"4) Task 27\n"
                +"5) Task 35\n"
                +"6) Exit.\n"
                +"Choose task: ");
    }

    public static void main(String[] args) {
        boolean bool = true;
        while (bool) {
            showMenu();
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                   Task3Runner.execute();
                    break;
                }
                case 2: {
                    Task11Runner.execute();
                    break;
                }
                case 3: {
                    Task19Runner.execute();
                    break;
                }
                case 4: {
                    Task27Runner.execute();
                    break;
                }
                case 5: {
                    Task35Runner.execute();
                    break;
                }
                case 6: {
                    logger.info("Exit");
                    bool = false;
                    break;
                }
                default:
                    logger.error("You can choose only 1-6");
                    break;
            }
        }
    }
}
