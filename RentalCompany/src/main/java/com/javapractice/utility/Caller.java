package com.javapractice.utility;

public class Caller {

    public static void main(String[] args) {
        ConfigReader configReader = ConfigReader.getInstance();
        configReader.showMessage();
        String PROPVALUES = configReader.getPropValues("costPerWeekBike");
        System.out.println(PROPVALUES);
    }

}
