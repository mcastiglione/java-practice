package com.javapractice.model.car;

import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

public class RentCarHour implements Rental {

    private Double fee;

    private Integer cars;

    private Integer hours;

    private Integer costPerHour;

    final static Logger logger = Logger.getLogger(RentCarHour.class);

    String message;

    public RentCarHour() {
        try {
            this.costPerHour = Integer.parseInt(file.getProperty("car.hour"));
        } catch (NumberFormatException e) {
            message = "ERROR! costPerDay is " + this.costPerHour;
            System.out.println(message);
            logger.error(message);
        }

    }

    @Override
    public boolean checkInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    public void calculateFee(int cars, int hours) {
        try {
            this.cars = cars;
            this.hours = hours;
            this.fee = this.cars.doubleValue()*this.hours.doubleValue()*this.costPerHour.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerHour is " + this.costPerHour + ", quantity of cars: " + this.cars + ", hours: " + this.hours;
            System.out.println(message);
            logger.error(message);
        }
    }

    public void logValues() {
        message = "RentCarHour; costPerHour is " + this.costPerHour + ", quantity of cars: " + this.cars + ", hours: " + this.hours;
        logger.info(message);
    }

    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.cars;
    }

    public Integer getHours() {
        return this.hours;
    }

    public Integer getCostPerHour() {
        return this.costPerHour;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.cars + " cars for " + this.hours + " hours for a total fee of " + this.fee);
    }
}