package com.javapractice.utility;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class RentalCompanyLogger {

    private final static Logger logger = Logger.getLogger(RentalCompanyLogger.class.getName());

    static {

        LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.WARNING);

        FileHandler fileTxt = null;

        try {
            fileTxt = new FileHandler("Logging.txt");
        } catch (java.io.IOException e) {
            System.out.println("Logging file not found!");
        }

        logger.addHandler(fileTxt);

    }

    private RentalCompanyLogger() {}

    private static class DbHolder {
        private static final RentalCompanyLogger INSTANCE = new RentalCompanyLogger();
    }

    public static RentalCompanyLogger getInstance()
    {
        return RentalCompanyLogger.DbHolder.INSTANCE;
    }

}