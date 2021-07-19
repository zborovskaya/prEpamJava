package by.zborovskaya.task06.view;

import by.zborovskaya.task06.control.command.Controller;
import by.zborovskaya.task06.entity.SquareMatrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainView {
    private static final Logger logger = LogManager.getLogger(MainView.class);


    /**
     *function {@link MainView#showMenu()}shows menu
     */
    public static void showMenu() {
        System.out.println("Menu: \n"
                +"1)FILL_WITH_LOCK \n"
                +"2)FILL_WITH_SEMAPHORE \n"
                +"3)ILL_WITH_CHANNELPOOL \n"
                +"4)FILL_WITH_PHASER \n"
                +"5)FILL_WITH_HASHMAP \n"
                +"Choose task: ");
    }

    public static void main(String[] args) {
        SquareMatrix matrix=null;
        final String PATH_OF_MATRIX="C:\\Users\\zav\\IdeaProjects\\prEpamJava" +
                "\\task06Concurrency\\data\\dataMatrix.txt";
        final String PATH_OF_THREADS="C:\\Users\\zav\\IdeaProjects\\prEpamJava\\task06Concurrency" +
                "\\data\\dataThreads.txt";
        showMenu();
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        Controller controller=new Controller();
        matrix=controller.executeTask(new CommandProviderView().getCommand(choice),PATH_OF_MATRIX,PATH_OF_THREADS);
        System.out.println(matrix.toString());
    }
}
