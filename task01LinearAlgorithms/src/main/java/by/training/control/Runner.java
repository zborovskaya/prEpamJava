package by.training.control;

import java.util.Scanner;

import by.training.entities.ThirdTask;
import by.training.entities.EleventhTask;
import by.training.entities.NineteenthTask;
import by.training.entities.TwentySeventhTask;
import by.training.entities.ThirtyFifthTask;

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
        System.out.println("Menu: ");
        System.out.println("1) Task 3: Find the value of the function z = 2 * x + (y - 2) * 5");
        System.out.println("2) Task 11: Find the perimeter and  square of a right triangle.");
        System.out.println("3) Task 19: There is The side of an equilateral triangle. Find the square,height, inscribed circle radius and radius of the circumscribed circle");
        System.out.println("4) Task 27: Find the value a^8 and a^10. You can only use *");
        System.out.println("5) Task 35: There are natural numbers M and N. Find the most significant digit of the fractional part and\n"
                +"   the least significant digit of the integer part of the number M / N.");
        System.out.println("6) Exit");
        System.out.println("Choose task: ");
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
                    System.out.println("Enter x and press <Enter> & y and press <Enter>:");
                    double x = scan.nextDouble();
                    double y = scan.nextDouble();
                    System.out.println("x=" + x+" y="+y);
                    ThirdTask thirdTask= new ThirdTask();
                    thirdTask.setX(x);
                    thirdTask.setY(y);
                    System.out.println("Z = " + thirdTask.calculate());
                    logger.info("Task completed successfully");
                    break;
                }
                case 2: {
                    logger.info("User chose Task 11");
                    System.out.println("Enter a and press <Enter> & number and b <Enter>:");
                    double a = scan.nextDouble();
                    double b = scan.nextDouble();
                    EleventhTask eleventhTask = new EleventhTask();
                    eleventhTask.setA(a);
                    eleventhTask.setB(b);
                    double p=eleventhTask.getPerimeter();
                    if (p!=0.0){
                    System.out.println("Perimeter is " + p);
                    logger.info("Function completed successfully");
                    }
                    double s=eleventhTask.getSquare();
                    if (s!=0.0) {
                        System.out.println("Square is " +s );
                        logger.info("Function completed successfully");
                    }

                    break;
                }
                case 3: {
                    logger.info("User chose Task 19");
                    System.out.println("Enter a and press <Enter> :");
                    double a = scan.nextDouble();
                    NineteenthTask nineteenthTask= new NineteenthTask();
                    nineteenthTask.setA(a);
                    double s=nineteenthTask.getSquare();
                    if(s!=0.0) {
                        System.out.println("Square is " + s);
                        logger.info("Function completed successfully");
                    }
                    double height=nineteenthTask.getHeight();
                    if(height!=0.0){
                        System.out.println("Height is "+height);
                        logger.info("Function completed successfully");
                    }
                    double rIn=nineteenthTask.getRadiusIn();
                    if(rIn!=0.0) {
                        System.out.println("Inscribed circle radius is " + rIn);
                        logger.info("Function completed successfully");
                    }
                    double rOut=nineteenthTask.getRadiusOut();
                    if(rOut!=0.0)
                    {
                        System.out.println("Radius of the circumscribed circle is " + rOut);
                        logger.info("Function completed successfully");
                    }
                    break;
                }
                case 4: {
                    logger.info("User chose Task 27");
                    System.out.println("Enter a and press <Enter>");
                    double a = scan.nextDouble();
                    TwentySeventhTask twentySeventhTask= new TwentySeventhTask();
                    twentySeventhTask.setA(a);
                   double [] result = twentySeventhTask.calculate();
                    System.out.println("a = " + a + "\nа8 = " + result[0] + " and а10 = " + result[1]);
                    logger.info("Task completed successfully");
                    break;
                }
                case 5: {
                    logger.info("User chose Task 35");
                    System.out.println("Enter m and press <Enter> & number and n <Enter>:");
                    int m = scan.nextInt();
                    int n = scan.nextInt();
                    ThirtyFifthTask thirtyFifthTask= new ThirtyFifthTask();
                    thirtyFifthTask.setM(m);
                    thirtyFifthTask.setN(n);
                    int[] result = thirtyFifthTask.calculate();
                    System.out.println(" Least significant digit of integer part: " + result[0]);
                    System.out.println("The most significant digit of the fractional part: " + result[1]);
                    logger.info("Task completed successfully");
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
