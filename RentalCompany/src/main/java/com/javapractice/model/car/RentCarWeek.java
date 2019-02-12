package com.javapractice.model.car;

import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

public class RentCarWeek implements Rental {

    private Double fee;

    private Integer cars;

    private Integer weeks;

    private Integer costPerWeek;

    final static Logger logger = Logger.getLogger(RentCarWeek.class);

    String message;

    public RentCarWeek() {
        try {
            this.costPerWeek = Integer.parseInt(file.getProperty("car.week"));
        } catch (NumberFormatException e) {
            message = "ERROR! costPerWeek is " + this.costPerWeek;
            System.out.println(message);
            logger.error(message);
        }
    }

    @Override
    public boolean checkInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    public void calculateFee(int cars, int weeks) {
        try {
            this.cars = cars;
            this.weeks = weeks;
            this.fee = this.cars.doubleValue()*this.weeks.doubleValue()*costPerWeek.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerWeek is " + this.costPerWeek + ", quantity of cars: " + this.cars + ", weeks: " + this.weeks;
            System.out.println(message);
            logger.error(message);
        }
    }

    public void logValues() {
        message = "RentCarWeek; costPerWeek is " + this.costPerWeek + ", quantity of cars: " + this.cars + ", weeks: " + this.weeks;
        logger.info(message);
    }

    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.cars;
    }

    public Integer getWeeks() {
        return this.weeks;
    }

    public Integer getCostPerWeek() {
        return this.costPerWeek;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.cars + " cars for " + this.weeks + " weeks for a total fee of " + this.fee);
    }
}