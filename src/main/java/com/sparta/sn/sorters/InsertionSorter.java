package com.sparta.sn.sorters;

public class InsertionSorter implements Sorter{
    public int[] sortArray(int[] unsortedArray) {
        for (int i=1; i<unsortedArray.length; i++) {
            int currentValue = unsortedArray[i];
            int previousIndex = i-1;

            while(previousIndex >= 0 && currentValue < unsortedArray[previousIndex]) {
                unsortedArray[previousIndex+1] = unsortedArray[previousIndex];
                previousIndex = previousIndex - 1;
            }
            unsortedArray[previousIndex+1] = currentValue;
        }
        return unsortedArray;
    }

    @Override
    public String toString() { return "Insertion Sorter"; }
}
