package com.sparta.sn.sorters;

public class QuickSorter implements Sorter {
    public int[] sortArray(int[] unsortedArray) {
        quickSortArray(unsortedArray, 0, unsortedArray.length-1);
        return  unsortedArray;
    }

    private  void quickSortArray(int[] unsortedArray, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(unsortedArray, left, right);
            quickSortArray(unsortedArray, left, pivotIndex - 1);
            quickSortArray(unsortedArray, pivotIndex, right);
        }
    }

    private int partition(int[] unsortedArray, int left, int right) {
        int pivotValue = unsortedArray[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (unsortedArray[j] <= pivotValue) {
                swap(unsortedArray, ++i, j);
            }
        }
        swap(unsortedArray, ++i, right);
        return i;
    }

    private void swap(int[] unsortedArray, int index1, int index2) {
        int temp = unsortedArray[index1];
        unsortedArray[index1] = unsortedArray[index2];
        unsortedArray[index2] = temp;
    }

    @Override
    public String toString() { return "Quick Sorter"; }
}