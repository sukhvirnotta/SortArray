package com.sparta.sn.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class InsertionSorter implements Sorter {

    private static Logger log = Logger.getLogger(InsertionSorter.class.getName());

    public int[] sortArray(int[] unsortedArray) {
        log.debug("Unsorted array: " + Arrays.toString(unsortedArray));
        int j;
        for (int i = 1; i < unsortedArray.length; i++) {
            j = i;
            while (j > 0 && unsortedArray[j - 1] > unsortedArray[j]) {
                int temp = unsortedArray[j];
                unsortedArray[j] = unsortedArray[j - 1];
                unsortedArray[j - 1] = temp;

                j = j - 1;
            }
            log.debug("Array after inserting element " + unsortedArray[j] + ": " + Arrays.toString(unsortedArray));
        }
        log.debug("Sorted array: " + Arrays.toString(unsortedArray));
        return unsortedArray;
    }

    @Override
    public String toString() {
        return "Insertion Sorter";
    }
}
