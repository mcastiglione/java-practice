package com.javapractice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Rent implements Rental {

    private InputStream inputStream;

    private Double fee;

    private Integer time;

    private String timeUnit;

    private String rentalType;

    private Integer rentalQty;

    private Integer costPerTimeUnit;

    public Rent(int rentalQty, int time, String timeUnit, String rentalType) {
        this.rentalQty = rentalQty;
        this.time = time;
        this.timeUnit = timeUnit;
        this.rentalType = rentalType;
    }

    @Override
    public boolean checkInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    public void readConfig(String path) {
        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(path);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
            }

            this.costPerTimeUnit = Integer.parseInt(prop.getProperty("costper" + timeUnit + rentalType));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }

    @Override
    public void calculateFee() {
        this.fee = this.rentalQty.doubleValue()*this.time.doubleValue()*this.costPerTimeUnit.doubleValue();
    }

    public Double getFee() {
        return this.fee;
    }

    public Integer getRentalQty() {
        return this.rentalQty;
    }

    public Integer getCostPerWeek() {
        return this.costPerTimeUnit;
    }

    public Integer getTime() {
        return time;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public String getRentalType() {
        return rentalType;
    }

    @Override
    public String toString() {
        //example: You will rent 1 bikes for 1 hours for a total fee of 10
        return new String("You will rent "		+ this.getRentalQty()	+ this.getRentalType()
                + "s for "
                + this.getTime()	+ this.getTimeUnit()
                + "s for a total fee of "
                + this.getFee()
                + ".");
    }
}