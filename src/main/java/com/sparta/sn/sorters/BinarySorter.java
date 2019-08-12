package com.sparta.sn.sorters;

import com.sparta.sn.binaryTree.BinarySearchTree;
import com.sparta.sn.binaryTree.BinaryTree;

public class BinarySorter implements Sorter {
    @Override
    public int[] sortArray(int[] unsortedArray) {
        BinaryTree binaryTree = new BinarySearchTree(unsortedArray);
        return binaryTree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "Binary Sorter";
    }
}
