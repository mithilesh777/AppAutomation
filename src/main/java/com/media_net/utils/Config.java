package com.media_net.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mithilesh.singh
 * This Class will activate the properties file to read the values and assign at runtime to avoid the hard coded values.
 * Helps to achieve data driven framework
 */

public class Config {

    private Properties properties;
    public Config(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}