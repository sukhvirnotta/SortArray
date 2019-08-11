package com.sparta.sn.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class BubbleSorter implements Sorter {

    private static Logger log = Logger.getLogger(BubbleSorter.class.getName());

    public int[] sortArray(int[] unsortedArray) {
        log.debug("Unsorted array: " + Arrays.toString(unsortedArray));
        int length = unsortedArray.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    int temp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i + 1];
                    unsortedArray[i + 1] = temp;
                    swapped = true;
                    log.debug("Swapped elements " + unsortedArray[i] + " and " + unsortedArray[i + 1]);
                    log.debug("Array after swap: " + Arrays.toString(unsortedArray));
                }
            }
            log.debug("Array after pass: " + Arrays.toString(unsortedArray));
        }
        log.debug("Sorted array: " + Arrays.toString(unsortedArray));
        return unsortedArray;
    }

    @Override
    public String toString() {
        return "Bubble Sorter";
    }
}
