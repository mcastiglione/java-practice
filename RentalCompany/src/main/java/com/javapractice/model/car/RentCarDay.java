package com.javapractice.model.car;

import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

public class RentCarDay implements Rental {

    private Double fee;

    private Integer cars;

    private Integer days;

    private Integer costPerDay;

    final static Logger logger = Logger.getLogger(RentCarDay.class);

    String message;

    public RentCarDay() {
        try {
            this.costPerDay = Integer.parseInt(file.getProperty("car.day"));
        } catch (NumberFormatException e) {
            message = "ERROR! costPerDay is " + this.costPerDay;
            System.out.println(message);
            logger.error(message);
        }

    }

    @Override
    public boolean checkInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    public void calculateFee(int cars, int days) {
        try {
            this.cars = cars;
            this.days = days;
            this.fee = this.cars.doubleValue()*this.days.doubleValue()*costPerDay.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerDay is " + this.costPerDay + ", quantity of cars: " + this.cars + ", days: " + this.days;
            System.out.println(message);
            logger.error(message);
        }
    }

    public void logValues() {
        message = "RentCarDay; costPerDay is " + this.costPerDay + ", quantity of cars: " + this.cars + ", days: " + this.days;
        logger.info(message);
    }

    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.cars;
    }

    public Integer getDays() {
        return this.days;
    }

    public Integer getCostPerDay() {
        return this.costPerDay;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.cars + " cars for " + this.days + " days for a total fee of " + this.fee);
    }
}