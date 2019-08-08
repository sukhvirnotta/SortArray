package com.sparta.sn.controller;

import com.sparta.sn.display.DisplayManager;
import com.sparta.sn.sorters.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SortManager {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(SortManager.class.getName());

    public void runSortArray() {
        initialiseLogging();
        int[] unsortedArray = {6, 3, 7, 9, 2, 1, 10, 7};
        Sorter sorter = SortFactory.getInstance();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        new DisplayManager().displaySorterType(sorter.toString());
        new DisplayManager().displayArray(sortedArray);
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.trace("Logging initialised");
    }
}
