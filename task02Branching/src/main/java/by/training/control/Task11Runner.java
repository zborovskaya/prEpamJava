package by.training.control;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.service.task11.*;
import by.training.service.exception.*;
import by.training.service.creator.*;
import by.training.entity.Triangle;

/**
 * Class execute Task 11
 */

public class Task11Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    /**
     * If the user enters sides that do not form a triangle,
     *  the function catches an error.
     */

    public static void execute(){
        Scanner scan = new Scanner(System.in);

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
            Triangle secondTriangle= secondCreator.create(a,b,c);

            int answer = CompareTriangle.compareSquare(firstTriangle, secondTriangle);
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
    }
}
