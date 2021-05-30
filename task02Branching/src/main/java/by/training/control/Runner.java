package by.training.control;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import by.training.service.*;
import by.training.service.task11.*;
import by.training.exception.*;
import by.training.creator.*;

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
                    System.out.println("Enter a and press <Enter>");
                    double a = scan.nextDouble();
                    Task3 task3= new Task3();
                    System.out.println(task3.compare(a));
                    logger.info("Function completed successfully");
                    break;
                }
                case 2: {
                    try {
                        logger.info("User chose Task 11");

                        System.out.println("First triangle: enter a and press <Enter> &  b and press <Enter> & c and press <Enter> :");
                        double a = scan.nextDouble();
                        double b = scan.nextDouble();
                        double c = scan.nextDouble();
                        TriangleCreator firstCreator = new TriangleCreator();
                        Triangle firstTriangle = firstCreator.create(a, b, c);


                        System.out.println("Second triangle: enter a and press <Enter> &  b and press <Enter> & c and press <Enter> :");
                        a = scan.nextDouble();
                        b = scan.nextDouble();
                        c = scan.nextDouble();
                        TriangleCreator secondCreator = new TriangleCreator();
                        Triangle secondTriangle = secondCreator.create(a, b, c);


                        CompareTriangle compareTriangle = new CompareTriangle();
                        int answer = compareTriangle.compareSquare(firstTriangle, secondTriangle);
                        switch (answer) {
                                case 1:
                                    System.out.println("The square of the first triangle is larger than the second triangle");
                                    break;
                                case 0:
                                    System.out.println("Triangles are equal");
                                    break;
                                case -1:
                                    System.out.println("The square of the second triangle is larger than the first triangle");
                                    break;
                                }

                        logger.info("Function completed successfully");
                    }


                    catch (TriangleException ex) {
                        logger.error(ex.getMessage());
                    }
                    break;
                }
                case 3: {
                    logger.info("User chose Task 19");

                    System.out.println("Enter a and press <Enter> &  b and press <Enter> & c and press <Enter> :");
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    double c = scan.nextDouble();
                    Task19 task19 = new Task19();
                    System.out.println("Amount of positive numbers is " +task19.calculate(a,b,c));
                    logger.info("Function completed successfully");
                    break;
                }
                case 4: {
                    logger.info("User chose Task 27");

                    System.out.println("Enter a and press <Enter> &  b and press <Enter> & c and press <Enter> & d and press <Enter>:");
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    double c = scan.nextDouble();
                    double d = scan.nextDouble();
                    Task27 task27= new Task27();
                    System.out.println("max{min(a, b), min(c, d)} = "+task27.findMaxAmongMin(a,b,c,d));
                    logger.info("Function completed successfully");
                    break;
                }
                case 5: {
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
