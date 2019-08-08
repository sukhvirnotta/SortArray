package com.sparta.sn.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class InsertionSorter implements Sorter{

    private static Logger log = Logger.getLogger(InsertionSorter.class.getName());

    public int[] sortArray(int[] unsortedArray) {
        log.debug("Unsorted array: " + Arrays.toString(unsortedArray));
        for (int i=1; i<unsortedArray.length; i++) {
            int currentValue = unsortedArray[i];
            int previousIndex = i-1;

            while(previousIndex >= 0 && currentValue < unsortedArray[previousIndex]) {
                unsortedArray[previousIndex+1] = unsortedArray[previousIndex];
                previousIndex = previousIndex - 1;
            }
            unsortedArray[previousIndex+1] = currentValue;
            log.debug("Array after inserting element " + currentValue + " : " + Arrays.toString(unsortedArray));
        }
        log.debug("Sorted array: " + Arrays.toString(unsortedArray));
        return unsortedArray;
    }

    @Override
    public String toString() { return "Insertion Sorter"; }
}
