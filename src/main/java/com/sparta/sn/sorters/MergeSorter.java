package com.sparta.sn.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class MergeSorter implements Sorter {

    private static Logger log = Logger.getLogger(MergeSorter.class.getName());

    public int[] sortArray(int[] arrayToSort) {
        int[] unsortedArray = arrayToSort.clone();
        log.debug("Unsorted array: " + Arrays.toString(unsortedArray));
        mergeSortArray(unsortedArray);
        log.debug("Sorted array: " + Arrays.toString(unsortedArray));
        return unsortedArray;
    }

    private void mergeSortArray(int[] unsortedArray) {
        int length = unsortedArray.length;
        if (length < 2) {
            return;
        }
        int middle = length / 2;
        int[] left = Arrays.copyOfRange(unsortedArray, 0, middle);
        int[] right = Arrays.copyOfRange(unsortedArray, middle, length);

        log.debug("Left array: " + Arrays.toString(left));
        log.debug("Right array: " + Arrays.toString(right));

        sortArray(left);
        sortArray(right);

        mergeArrays(unsortedArray, left, right);
    }

    private void mergeArrays(int[] originalArray, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                originalArray[k] = leftArray[i];
                i++;
            } else {
                originalArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            originalArray[k] = leftArray[i];
            k++;
            i++;
        }

        while (j < rightArray.length) {
            originalArray[k] = rightArray[j];
            k++;
            j++;
        }
    }

    @Override
    public String toString() {
        return "Merge Sorter";
    }
}
