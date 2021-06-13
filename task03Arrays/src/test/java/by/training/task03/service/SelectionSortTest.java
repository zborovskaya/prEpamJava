package by.training.task03.service;

import by.training.task03.entity.Array;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectionSortTest {

    @Test
    public void testSortIncOrder() {
        Array array = new Array(new int[] {4, -7, 8, 100, 0, 6, 55, 44, 57});
        Array expected = new Array(new int[] {-7, 0, 4, 6, 8, 44, 55, 57, 100});

       SelectionSort selectionSort= new SelectionSort();

        selectionSort.sort(array, true);
        assertEquals(array, expected);
    }

    @Test
    public void testSortDecrOrder() {
        Array array = new Array(new int[] {4, -7, 8, 100, 0, 6, 55, 44, 57});
        Array expected = new Array(new int[] {100, 57, 55, 44, 8, 6, 4, 0, -7});

        SelectionSort selectionSort= new SelectionSort();
        selectionSort.sort(array, false);
        assertEquals(array, expected);
    }
}