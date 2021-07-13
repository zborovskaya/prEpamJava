package by.training.task03.dao;

import java.io.*;
import java.util.*;

public class ArrayDAOImpl implements ArrayDAO {

    //Укажите свой файл
    String initTxt = "C:/Users/zav/IdeaProjects/prEpamJava/task03Arrays/src/main/data/inputData.txt";
    String resultTxt = "C:/Users/zav/IdeaProjects/prEpamJava/task03Arrays/src/main/data/result.txt";
    Scanner scanner;
    PrintWriter pw ;

    public int[] readArrayFromFile() {
        return readFromFile(initTxt);
    }

    public void writeResultArrayToFile(int[] array) {

        try {
            pw = new PrintWriter(new FileWriter(resultTxt));
            for (int value : array) {
                pw.print(value);
                pw.print("\t");
            }
            pw.close();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public void clearFile() {
        try {
            PrintWriter pw = new PrintWriter(resultTxt);
            pw.close();
        } catch (Exception e) {
            System.out.println("Error while clearing the file");
        }
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    public int[] readFromFile(String path) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        int[] numbers = new int[0];
        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNext()) {
                integers.add(scanner.nextInt());
            }
            numbers = new int[integers.size()];
            numbers = convertIntegers(integers);
        } catch (Exception e ) {
            System.out.println("There is not file");
        }
        return numbers;
    }
}
