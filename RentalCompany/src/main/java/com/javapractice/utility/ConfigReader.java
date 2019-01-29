package com.javapractice.utility;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static ConfigReader configReader = new ConfigReader();
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

    //make the constructor private so that this class cannot be
    //instantiated
    private ConfigReader(){

    }

    //Get the only object available
    public static ConfigReader getInstance(){
        return configReader;
    }

    public void showMessage() {
        System.out.println("it works!");
    }

    public String getPropValues(String property) {
        String result = null;
        try {
            Properties prop = new Properties();

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found in the classpath");
            }

            result = prop.getProperty(property);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println(result);
        System.out.println(property);
        return result;
    }

}