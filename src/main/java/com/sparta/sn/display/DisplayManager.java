package com.sparta.sn.display;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {
    private Scanner scanner = new Scanner(System.in);

    public String displaySortTypeRequest(String path) {
        System.out.println("Enter the number of the sorter you would like to use");
        String[] sortNames = getMenuItems(path);
        String sortType = scanner.nextLine();
        return sortNames[Integer.parseInt(sortType) - 1];
    }

    public String displayArraySizeRequest() {
        System.out.println("Please enter the size of array");
        return scanner.nextLine();
    }

    public void displayUnsortedArray(String sorterName, int[] unsortedArray) {
        System.out.println("Sorting using the " + sorterName);
        System.out.println("Before sorting:\n" + Arrays.toString(unsortedArray));
    }

    public void displaySortedArray(int[] sortedArray) {
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
    }

    private String[] getMenuItems(String path) {
        File sortDirectory = new File(path);
        String[] names = sortDirectory.list();
        String[] filteredNames = new String[names.length - 1];
        for (int i = 0; i < names.length; i++) {
            if (!(names[i].equals("Sorter.java"))) {
                filteredNames[i] = names[i];
            }
        }
        Arrays.sort(filteredNames != null ? filteredNames : new String[0]);
        int index = 1;
        for (String name : filteredNames) {
            name = name.substring(0, name.indexOf('.'));
            System.out.println(index + ". " + name);
            index++;
        }
        return names;
    }


}
