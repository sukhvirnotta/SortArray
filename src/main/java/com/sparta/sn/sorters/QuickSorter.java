package com.sparta.sn.sorters;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Random;

public class QuickSorter implements Sorter {

    private static Logger log = Logger.getLogger(QuickSorter.class.getName());

    public int[] sortArray(int[] unsortedArray) {
        log.debug("Unsorted array: " + Arrays.toString(unsortedArray));
        quickSortArray(unsortedArray, 0, unsortedArray.length);
        log.debug("Sorted array: " + Arrays.toString(unsortedArray));
        return unsortedArray;
    }

    private void quickSortArray(int[] unsortedArray, int left, int right) {
        int l = left;
        int r = right - 1;
        int size = right - left;
        if (size > 1) {
            Random random = new Random();
            int pivot = unsortedArray[random.nextInt(size) + l];
            log.debug("Random pivot element: " + pivot);
            while (l < r) {
                while (unsortedArray[r] > pivot && r > l) {
                    r--;
                }
                while (unsortedArray[l] < pivot && l <= r) {
                    l++;
                }
                if (l < r) {
                    int temp = unsortedArray[l];
                    unsortedArray[l] = unsortedArray[r];
                    unsortedArray[r] = temp;
                    log.debug("Swapped elements " + unsortedArray[l] + " and " + unsortedArray[r]);
                    log.debug("Array after swap: " + Arrays.toString(unsortedArray));
                    l++;
                }
            }
            quickSortArray(unsortedArray, left, l);
            quickSortArray(unsortedArray, r, right);
        }
    }

    @Override
    public String toString() {
        return "Quick Sorter";
    }
}