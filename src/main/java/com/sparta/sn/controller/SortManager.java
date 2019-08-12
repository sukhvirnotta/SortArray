package com.sparta.sn.controller;

import com.sparta.sn.display.DisplayManager;
import com.sparta.sn.exception.SorterLoaderException;
import com.sparta.sn.sorters.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Random;

public class SortManager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    private DisplayManager displayManager = new DisplayManager();
    private SorterLoader sorterLoader = new SorterLoader();

    public void runSortArray() {
        try {
            initialiseLogging();
            String sortType = displayManager.displaySortTypeRequest(sorterLoader.getSortersLocation());
            int sizeOfArray = displayManager.displayArraySizeRequest();

            int[] unsortedArray = createArray(sizeOfArray);
            Sorter sorter = selectSorter(sortType);
            printBeforeSort(sorter.toString(), unsortedArray);
            int[] sortedArray = sorter.sortArray(unsortedArray);
            printAfterSort(sortedArray);
        } catch (SorterLoaderException e) {
            e.printStackTrace();
        }
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.trace("Logging initialised");
    }

    private int[] createArray(int size) {
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for (int i = 0; i < size; i++) {
            unsortedArray[i] = random.nextInt(size * 10) + 1;
        }
        return unsortedArray;
    }

    private Sorter selectSorter(String sortType) throws SorterLoaderException {
        return sorterLoader.getSorter(sortType);
    }

    private void printBeforeSort(String sorter, int[] unsortedArray) {
        displayManager.displayUnsortedArray(sorter, unsortedArray);
    }

    private void printAfterSort(int[] sortedArray) {
        displayManager.displaySortedArray(sortedArray);
    }
}
