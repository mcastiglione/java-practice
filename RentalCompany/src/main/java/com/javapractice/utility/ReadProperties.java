package com.javapractice.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadProperties {

    private static final String CONFIG_FILE_NAME ="/config.properties";
    final static Logger LOG = LoggerFactory.getLogger(ReadProperties.class);

    private static Properties props;

    static {
        InputStream in = null;
        try {
            props = new Properties();
            in = ClassLoader.class.getResourceAsStream(CONFIG_FILE_NAME);
            props.load(in);
        } catch (IOException e) {
            LOG.error("Error when open file {}: ", CONFIG_FILE_NAME, e);
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