package by.training.task03.dao;

public interface ArrayDAO {

    int[] readArrayFromFile();
    void writeResultArrayToFile(int[] array);
    void clearFile();

}
