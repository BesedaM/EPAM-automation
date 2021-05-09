package by.epam.learn.automation.task0304.service;

import java.util.ResourceBundle;

public class DataReader {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));

    public static String getData(String key) {
        return resourceBundle.getString(key);
    }
}
