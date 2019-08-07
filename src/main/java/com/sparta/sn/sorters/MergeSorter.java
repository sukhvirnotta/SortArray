package com.sparta.sn.sorters;

import java.util.Arrays;

public class MergeSorter implements Sorter {
    public int[] sortArray(int[] unsortedArray) {
        mergeSortArray(unsortedArray);
        return unsortedArray;
    }

    public void mergeSortArray(int[] unsortedArray)  {
        int length = unsortedArray.length;
        if (length < 2) {
            return;
        }
        int middle = length/2;
        int[] left = Arrays.copyOfRange(unsortedArray, 0, middle);
        int[] right = Arrays.copyOfRange(unsortedArray, middle, length);

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
    public String toString() { return "Merge Sorter"; }
}
