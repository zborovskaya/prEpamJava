package by.zborovskaya.task04.view;

import by.zborovskaya.task04.control.Controller;
import by.zborovskaya.task04.manager.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Zborovskaya Anna
 * Class {@code ViewMain} starts tasks
 *The view forms a request - a string of a certain type, passes it to the controller
 * and waits for a response.
 */

public class ViewMain {
    private static final Logger logger = LogManager.getLogger(ViewMain.class);

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Scanner scanBody = new Scanner(System.in);
        String headline=null;
        String textBody=null;
        String request=null;

        try {
            Map<Integer, MessageManager> langChoosing = new HashMap<Integer, MessageManager>();
            langChoosing.put(1, MessageManager.RU);
            langChoosing.put(2, MessageManager.EN);
            System.out.println("Choose language: \n1)RU \n2)EN");
            int choice = scan.nextInt();
            if (choice!=1 && choice!=2) throw new Exception("You can choose only 1 or 2");
            MessageManager current = langChoosing.get(choice);
            System.out.println(current.getString("menu"));
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println(current.getString("headEntering"));
                    headline = scan.next();
                    System.out.println(current.getString("bodyEntering"));
                    textBody = scanBody.nextLine();
                    request = "CREATE_TEXT";
                    break;
                }
                case 2: {
                    System.out.println(current.getString("bodyEntering"));
                    textBody = scanBody.nextLine();
                    request = "ADD_DATA";
                    break;
                }
                case 3: {
                    request = "READ_TEXT";
                    break;
                }
                case 4: {
                    request = "READ_HEADLINE";
                    break;
                }
                case 5: {
                    request = "CLEAR_TEXT";
                    break;
                }
                default:
                    logger.error(current.getString("errorMenu"));
                    break;
            }
            Controller controller = new Controller();
            controller.executeTask(request, headline, textBody);
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }
}
