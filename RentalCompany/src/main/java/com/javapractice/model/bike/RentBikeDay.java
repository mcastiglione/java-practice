package com.javapractice.model.bike;

import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

public class RentBikeDay implements Rental {

    private Double fee;

    private Integer bikes;

    private Integer days;

    private Integer costPerDay;

    final static Logger logger = Logger.getLogger(RentBikeDay.class);

    String message;

    public RentBikeDay() {
        try {
            this.costPerDay = Integer.parseInt(file.getProperty("bike.day"));
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

    public void calculateFee (int bikes, int days) {
        try {
            this.bikes = bikes;
            this.days = days;
            this.fee = this.bikes.doubleValue() * this.days.doubleValue() * costPerDay.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerDay is " + this.costPerDay + ", quantity of bikes: " + this.bikes + ", days: " + this.days;
            logger.error(message);
        }
    }

    public void logValues () {
        message = "RentBikeDay; costPerDay is " + this.costPerDay + ", quantity of bikes: " + this.bikes + ", days: " + this.days;
        logger.info(message);
    }


    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.bikes;
    }

    public Integer getDays() {
        return this.days;
    }

    public Integer getCostPerDay() {
        return this.costPerDay;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.bikes + " bikes for " + this.days + " days for a total fee of " + this.fee);
    }
}