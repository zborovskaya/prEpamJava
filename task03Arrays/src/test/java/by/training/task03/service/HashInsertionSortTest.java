package by.training.task03.service;

import by.training.task03.entity.Array;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HashInsertionSortTest {

    @Test
    public void testSortIncOrder() {
        Array array = new Array(new int[] {6, 10, 20, 33, 4, 96, 0, 66, 1});
        Array expected = new Array(new int[] {0, 1, 4, 6, 10, 20, 33, 66, 96});

        HashInsertionSort hashInsertionSort = new HashInsertionSort();
        hashInsertionSort.sort(array, true);
        assertEquals(array, expected);
    }

    @Test
    public void testSortDecrOrder() {
        Array array = new Array(new int[] {6, 10, 20, 33, 4, 96, 0, 66, 1});
        Array expected = new Array(new int[] {96, 66, 33, 20, 10, 6, 4, 1, 0});

        HashInsertionSort hashInsertionSort = new HashInsertionSort();
        hashInsertionSort.sort(array, false);
        assertEquals(array, expected);
    }
}