package by.zborovskaya.task06.control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     *function {@link Main#showMenu()}shows menu
     */
    public static void showMenu() {
        System.out.println("Menu: \n"
                +"1) \n"
                +"2) \n"
                +"3) \n"
                +"4) \n"
                +"Choose task: ");
    }

    public static void main(String[] args) {
        showMenu();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1: {
                FirstWayRunner firstWayRunner = new FirstWayRunner();
                firstWayRunner.execute();
                logger.info("Task completed successfully");
                break;
            }
            case 2: {
                SecondWayRunner secondWayRunner = new SecondWayRunner();
                secondWayRunner.execute();
                logger.info("Task completed successfully");
                break;
            }
            case 3: {
                ChannelPoolRunner channelPoolRunner = new ChannelPoolRunner();
                channelPoolRunner.execute();
                logger.info("Task completed successfully");
                break;
            }
            case 4: {
                FourthWayRunner fourthWayRunner = new FourthWayRunner();
                fourthWayRunner.execute();
                logger.info("Task completed successfully");
                break;
            }
            default:
                logger.error("You can choose only 1-6");
                break;
        }
    }
}
