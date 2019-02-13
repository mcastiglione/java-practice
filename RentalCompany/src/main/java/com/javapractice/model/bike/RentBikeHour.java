package com.javapractice.model.bike;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javapractice.model.Rental;

public class RentBikeHour implements Rental {

    private Double fee;

    private Integer bikes;

    private Integer hours;

    private Integer costPerHour;

    final static Logger LOG = LoggerFactory.getLogger(RentBikeHour.class);

    String message;

    public RentBikeHour() {
        try {
            this.costPerHour = Integer.parseInt(file.getProperty("bike.hour"));
        } catch (NumberFormatException e) {
            message = "ERROR! costPerHour is " + this.costPerHour;
            System.out.println(message);
            LOG.error(message);
        }
    }

    @Override
    public boolean isInfoOK() {
        // TODO Auto-generated method stub
        return false;
    }

    public void calculateFee (int bikes, int hours) {
        try {
            this.bikes = bikes;
            this.hours = hours;
            this.fee = this.bikes.doubleValue()*this.hours.doubleValue()*this.costPerHour.doubleValue();
        } catch (NullPointerException e) {
            message = "ERROR! costPerHour is " + this.costPerHour + ", quantity of bikes: " + this.bikes + ", hours: " + this.hours;
            LOG.error(message);
        }
    }

    public void logValues () {
        message = "RentBikeHour; costPerHour is " + this.costPerHour + ", quantity of bikes: " + this.bikes + ", hours: " + this.hours;
        LOG.info(message);
    }

    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.bikes;
    }

    public Integer getHours() {
        return this.hours;
    }

    public Integer getCostPerHour() {
        return this.costPerHour;
    }

    @Override
    public String toString() {
        return new String("You will rent " + this.bikes + " bikes for " + this.hours + " hours for a total fee of " + this.fee);
    }
}