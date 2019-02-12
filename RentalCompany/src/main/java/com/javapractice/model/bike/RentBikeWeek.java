package com.javapractice.model.bike;

import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

public class RentBikeWeek implements Rental {

    private Double fee;

    private Integer bikes;

    private Integer weeks;

    private Integer costPerWeek;

    final static Logger logger = Logger.getLogger(RentBikeWeek.class);

    String message;

    public RentBikeWeek() {
        try {
            this.costPerWeek = Integer.parseInt(file.getProperty("bike.week"));
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

    public void calculateFee(int bikes, int weeks) {
        try {
            this.bikes = bikes;
            this.weeks = weeks;
            this.fee = this.bikes.doubleValue()*this.weeks.doubleValue()*costPerWeek.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerWeek is " + this.costPerWeek + ", quantity of bikes: " + this.bikes + ", weeks: " + this.weeks;
            logger.error(message);
        }
    }

    public void logValues() {
        message = "RentBikeWeek; costPerWeek is " + this.costPerWeek + ", quantity of bikes: " + this.bikes + ", weeks: " + this.weeks;
        logger.info(message);
    }

    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.bikes;
    }

    public Integer getWeeks() {
        return this.weeks;
    }

    public Integer getCostPerWeek() {
        return this.costPerWeek;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.bikes + " bikes for " + this.weeks + " weeks for a total fee of " + this.fee);
    }
}