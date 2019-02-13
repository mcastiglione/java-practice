package com.javapractice.utility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javapractice.model.FamilyRental;
import com.javapractice.model.Rental;

public class RentFamily implements FamilyRental {

    private Double fee = 0.0;

    private List<Rental> rentals;

    private Integer discount;

    private Integer Qty = 0;

    final static Logger LOG = LoggerFactory.getLogger(RentFamily.class);

    String message;

    public RentFamily() {
    }

    @Override
    public boolean isInfoOK() {
        return (Qty > 5 || Qty < 3)? false: true;
    }

    public void calculateFee(List<Rental> rentals, int discount) {
        try {
            this.rentals = rentals;
            this.discount = discount;

            this.rentals.stream().forEach(y->this.fee += y.getFee());
            this.fee = this.fee - (this.fee/100*this.discount.doubleValue());

            this.rentals.stream().forEach(y->this.Qty += y.getQty());
        }
        catch (NullPointerException e) {
            LOG.error("RentFamily Error! At least one rental has null values");
            LOG.error("Rentals go:");
            this.rentals.stream().forEach(y->y.logValues());
            LOG.error("Finish RentFamily error;");
        }
    }

    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getQty() {
        return this.Qty;
    }

    @Override
    public String toString() {
        String returnString = new String("Family Rental cost: " + this.fee);
        return returnString;
    }
}