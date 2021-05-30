package by.training.control;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.training.service.*;
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
                    logger.info("User chose Task 3");

                   Task3 task3= new Task3();
                   System.out.println(task3.printTable());

                    logger.info("Function completed successfully");
                    break;
                }
                case 2: {
                    logger.info("User chose Task 11");

                    Task11 task11=new Task11();
                    System.out.println("Difference of cubes of the first two hundred numbers is "+task11.calculate());

                    logger.info("Function completed successfully");
                    break;
                }
                case 3: {
                    logger.info("User chose Task 19");

                    System.out.println("Enter e and press <Enter>");
                    double e = scan.nextDouble();
                    Task19 task19=new Task19();
                    System.out.println("Sum is " + task19.calculate(e));

                    logger.info("Function completed successfully");
                    break;
                }
                case 4: {
                    try {
                        logger.info("User chose Task 27");

                        System.out.println("Enter m and press <Enter> & n and press <Enter>");
                        int m = scan.nextInt();
                        int n = scan.nextInt();
                        Task27 task27 = new Task27();
                        String result=task27.calculateDivisors(m, n);
                        if(result=="") throw new Exception();
                        System.out.println(result);

                        logger.info("Function completed successfully");
                    }

                    catch (Exception ex) {
                        logger.error("Incorrectly entered m and n");
                    }
                    break;
                }
                case 5: {
                    try {
                        logger.info("User chose Task 35");

                        System.out.println("Enter m and press <Enter>");
                        int m = scan.nextInt();
                        Task35 task35 = new Task35();
                        int count=task35.calculate(m);
                        if (count==-1) throw new Exception();
                        System.out.println("Number of even numbers is " + count);

                        logger.info("Function completed successfully");
                    }

                    catch (Exception ex) {
                        logger.error("m can't be  less than 0!");
                    }
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
