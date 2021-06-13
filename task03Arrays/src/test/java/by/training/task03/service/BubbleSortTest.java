package by.training.task03.service;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
 import by.training.task03.entity.Array;

public class BubbleSortTest {

    @Test
    public void testSortIncOrder() {
        Array array = new Array(new int[] {5, 7, 20, 44, 4, 78, 1, 55, 3});
        Array expected = new Array(new int[] {1, 3, 4, 5, 7, 20, 44, 55, 78});

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array, true);
        assertEquals(array, expected);
    }

    @Test
    public void testSortDecrOrder() {
        Array array = new Array(new int[] {5, 7, 20, 44, 4, 78, 1, 55, 3});
        Array expected = new Array(new int[] {78, 55, 44, 20, 7, 5, 4, 3, 1});

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array, false);
        assertEquals(array, expected);
    }
}