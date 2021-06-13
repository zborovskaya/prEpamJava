package by.training.task03.view;

import by.training.task03.control.Controller;
import by.training.task03.manager.MessageManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Zborovskaya Anna
 * Class {@code Main} starts tasks
 *
 */

public class Main {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Map<Integer , String> states = new HashMap<Integer, String>();
        states.put(1, "BUBBLE_SORTING");
        states.put(2, "INSERTION_SORTING");
        states.put(3, "MERGE_SORTING");
        states.put(4, "SELECTION_SORTING");
        states.put(5, "SHAKER_SORTING");
        states.put(6, "SHELL_SORTING");

        Map<Integer , MessageManager> langChoosing = new HashMap<Integer, MessageManager>();
        langChoosing.put(1, MessageManager.RU);
        langChoosing.put(2, MessageManager.EN);
        System.out.println("Choose language: \n1)RU \n2)EN");
        int choice = scan.nextInt();
        MessageManager current=langChoosing.get(choice);
        System.out.println(current.getString("sortMenu"));
        choice = scan.nextInt();
        System.out.println(current.getString("isIncreasing"));
        int order=scan.nextInt();
        if(choice>0 && choice<7) {
            String request = states.get(choice);
            Controller controller = new Controller();
            if(order==1) controller.executeTask(request, true);
            else controller.executeTask(request, false);
        }
        else System.out.println(current.getString("rightChoice"));
    }
}
