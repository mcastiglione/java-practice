package com.javapractice.utility;

import com.javapractice.model.FamilyRental;
import com.javapractice.model.Rental;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class RentFamily implements FamilyRental {

    private Double fee = 0.0;

    private ArrayList<Rental> rentals;

    private Integer discount;

    private Integer Qty = 0;

    final static Logger logger = Logger.getLogger(RentFamily.class);

    String message;

    public RentFamily() {
    }

    @Override
    public boolean checkInfo() {
        if (Qty > 5 || Qty < 3) {
            return false;
        } else {
            return true;
        }
    }

    public void calculateFee(ArrayList<Rental> rentals, int discount) {
        try {
            this.rentals = rentals;
            this.discount = discount;

            this.rentals.stream().forEach(y->this.fee += y.getFee());
            this.fee = this.fee - (this.fee/100*this.discount.doubleValue());

            this.rentals.stream().forEach(y->this.Qty += y.getQty());
        }
        catch (NullPointerException e) {
            logger.error("RentFamily Error! At least one rental has null values");
            logger.error("Rentals go:");
            this.rentals.stream().forEach(y->y.logValues());
            logger.error("Finish RentFamily error;");
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