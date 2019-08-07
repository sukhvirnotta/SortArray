package com.sparta.sn;

import com.sparta.sn.sorters.MergeSorter;
import com.sparta.sn.sorters.Sorter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class SorterTest
{
    private static Sorter sorter;
    private static int[] arrayToSort = {7, 3, 5, 2, 89, 45};

    @BeforeClass
    public static void init() {
        sorter = new MergeSorter();
    }

    @Test
    public void testIfSorted() {
        int[] sortedArray = sorter.sortArray(arrayToSort);
        assertEquals(arrayToSort.length, sortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testArrayLength() {
        int[] unsortedArray = {6, 17, 3, 7, 9, 2, 1, 12};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(unsortedArray.length, sortedArray.length);
    }

    @Test
    public void testOddSizedArray() {
        int[] unsortedArray = {7, 3, 5, 2, 89, 45, 16};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(unsortedArray.length, sortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testArrayContainingNegatives() {
        int[] unsortedArray = {-4, 2, -1, 7, 13, 34, -23};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(unsortedArray.length, sortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testArrayContainingDuplicates() {
        int[] unsortedArray = {7, 3, 5, 2, 7, 89, 16, 45, 16};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        assertEquals(unsortedArray.length, sortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};
        int[] sortedArray = sorter.sortArray(emptyArray);
        assertEquals(emptyArray.length, sortedArray.length);
    }

    @Test
    public void testSortedArray() {
        int[] sortedArrayTest = {2, 3, 5, 7, 10, 14, 17};
        int[] sortedArray = sorter.sortArray(sortedArrayTest);
        assertEquals(sortedArrayTest.length, sortedArray.length);
        for (int i = 0; i < sortedArray.length-1; i++) {
            assertTrue(sortedArray[i+1] >= sortedArray[i]);
        }
    }
}
