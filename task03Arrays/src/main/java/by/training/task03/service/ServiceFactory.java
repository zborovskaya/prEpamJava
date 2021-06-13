package by.training.task03.service;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final Sorting bubbleSort = new BubbleSort();
    private final Sorting insertionSort = new InsertionSort();
    private final Sorting mergeSort = new MergeSort();
    private final Sorting selectionSort = new SelectionSort();
    private final Sorting shakerSort = new ShakerSort();
    private final Sorting shellSort = new ShellSort();

    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return instance;
    }
    public Sorting getBubbleSort(){
        return bubbleSort;
    }
    public Sorting getInsertionSort(){
        return insertionSort;
    }
    public Sorting getMergeSort(){
        return mergeSort;
    }
    public Sorting getSelectionSort(){
        return selectionSort;
    }
    public Sorting getShakerSort(){
        return shakerSort;
    }
    public Sorting getShellSort(){
        return shellSort;
    }


}
