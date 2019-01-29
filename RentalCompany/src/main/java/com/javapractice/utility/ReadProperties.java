package com.javapractice.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;



public class ReadProperties {

    private static final Properties props = new Properties();

    static {
        InputStream in = ReadProperties.class.getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private ReadProperties() {

    }

    private static class PropHolder {
        private static final ReadProperties INSTANCE = new ReadProperties();
    }

    public static ReadProperties getInstance() {
        return PropHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return props.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return props.containsKey(key);
    }
}