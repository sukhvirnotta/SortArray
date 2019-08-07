package com.sparta.sn.controller;

import com.sparta.sn.sorters.*;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {

    private static final String PATH = "resources/factory.properties";

    public static Sorter getInstance() {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty("sorter");
            Class selectedSorter = Class.forName(sortType);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return new BubbleSorter();
    }
}
