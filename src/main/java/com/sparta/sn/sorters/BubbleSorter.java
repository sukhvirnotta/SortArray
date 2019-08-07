package com.sparta.sn.sorters;

public class BubbleSorter implements Sorter {
    public int[] sortArray(int[] unsortedArray) {
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
                }
            }
        }
        return unsortedArray;
    }

    @Override
    public String toString() { return "Bubble Sorter"; }
}
