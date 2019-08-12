package com.sparta.sn.binaryTree;

import com.sparta.sn.exception.ChildNotFoundException;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class BinarySearchTree implements BinaryTree {

    private static Logger log = Logger.getLogger(BinarySearchTree.class.getName());
    private Node root;
    private int elementCounter;

    public BinarySearchTree(int element) {
        root = new Node(element);
        log.debug("Root element: " + root.getValue());
        elementCounter++;
    }

    public BinarySearchTree(int[] elements) {
        root = new Node(elements[0]);
        log.debug("Root element: " + root.getValue());
        elementCounter++;
        for (int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    @Override
    public int getRootElement() {
        return root.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return elementCounter;
    }

    @Override
    public void addElement(int element) {
        if (findElement(element)) {
            log.debug("Element not added: " + element);
            return;
        }
        root = addElementRecursive(root, element);
        log.debug("Added element: " + element);
        elementCounter++;
    }

    private Node addElementRecursive(Node currentNode, int element) {
        if (currentNode == null) {
            return new Node(element);
        }

        if (element < currentNode.getValue()) {
            currentNode.setLeft(addElementRecursive(currentNode.getLeft(), element));
        } else if (element > currentNode.getValue()) {
            currentNode.setRight(addElementRecursive(currentNode.getRight(), element));
        }
        return currentNode;
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        boolean isFound = findElementRecursive(root, value);
        log.debug("Searching for element: " + value);
        if (isFound) {
            log.debug("Element found: " + value);
        } else {
            log.debug("Element not found: " + value);
        }
        return isFound;
    }

    private boolean findElementRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }
        if (currentNode.getValue() == value) {
            return true;
        }
        return (value < currentNode.getValue()) ? findElementRecursive(currentNode.getLeft(), value) : findElementRecursive(currentNode.getRight(), value);
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        try {
            return getLeftChildRecursive(root, element);
        } catch (NullPointerException e) {
            log.error("An exception occurred as left child not found for element " + element, e);
            throw new ChildNotFoundException("Left child not found for element " + element);
        }
    }

    private int getLeftChildRecursive(Node currentNode, int element) {
        if (currentNode.getValue() == element) {
            log.debug("Left child node found for element: " + element);
            return currentNode.getLeft().getValue();
        }
        return (element < currentNode.getValue()) ? getLeftChildRecursive(currentNode.getLeft(), element) : getLeftChildRecursive(currentNode.getRight(), element);
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        try {
            return getRightChildRecursive(root, element);
        } catch (NullPointerException e) {
            log.error("An exception occurred as right child not found for element " + element, e);
            throw new ChildNotFoundException("Right child not found for element " + element);
        }
    }

    private int getRightChildRecursive(Node currentNode, int element) {
        if (currentNode.getValue() == element) {
            log.debug("Right child node found for element: " + element);
            return currentNode.getRight().getValue();
        }
        return (element < currentNode.getValue()) ? getRightChildRecursive(currentNode.getLeft(), element) : getRightChildRecursive(currentNode.getRight(), element);
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedTreeArray = new int[elementCounter];
        int index = 0;
        getSortedTreeAscRecursive(root, sortedTreeArray, index);
        log.debug("Sorted tree in ascending order: " + Arrays.toString(sortedTreeArray));
        return sortedTreeArray;
    }

    private int getSortedTreeAscRecursive(Node currentNode, int[] sortedTreeArray, int index) {
        if (currentNode == null) {
            return index;
        }
        index = getSortedTreeAscRecursive(currentNode.getLeft(), sortedTreeArray, index);
        sortedTreeArray[index] = currentNode.getValue();
        index++;
        index = getSortedTreeAscRecursive(currentNode.getRight(), sortedTreeArray, index);
        return index;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedTreeArray = new int[elementCounter];
        int index = 0;
        getSortedTreeDescRecursive(root, sortedTreeArray, index);
        log.debug("Sorted tree in descending order: " + Arrays.toString(sortedTreeArray));
        return sortedTreeArray;
    }

    private int getSortedTreeDescRecursive(Node currentNode, int[] sortedTreeArray, int index) {
        if (currentNode == null) {
            return index;
        }
        index = getSortedTreeDescRecursive(currentNode.getRight(), sortedTreeArray, index);
        sortedTreeArray[index] = currentNode.getValue();
        index++;
        index = getSortedTreeDescRecursive(currentNode.getLeft(), sortedTreeArray, index);
        return index;
    }
}
