package com.qa.SauceDemo.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties properties;

    public configReader() {
        try {
            FileInputStream file = new FileInputStream("src/main/java/config.properties");
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}