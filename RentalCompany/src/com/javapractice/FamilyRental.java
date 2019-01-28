package com.javapractice;

import java.util.ArrayList;

import com.javapractice.Rental;

public class FamilyRental implements Rental {

    private Double fee = 0.0;

    private ArrayList<Rental> rentals;

    private Integer discount;

    private Integer rentalQty = 0;

    public FamilyRental(ArrayList<Rental> rentals, int discount) {
        this.rentals = rentals;
        this.discount = discount;
    }

    @Override
    public boolean checkInfo() {
        if (rentalQty > 5 || rentalQty < 3) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void calculateFee() {
        rentals.stream().forEach(y->this.fee += y.getFee());
        this.fee = this.fee - (this.fee/100*discount.doubleValue());

        rentals.stream().forEach(y->this.rentalQty += y.getRentalQty());
    }

    @Override
    public Double getFee() {
        return this.fee;
    }

    public Integer getTime() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        String returnString = new String("Family Rental cost: " + this.fee);
        return returnString;
    }

    @Override
    public Integer getRentalQty() {
        // TODO Auto-generated method stub
        return rentalQty;
    }

    @Override
    public void readConfig(String string) {
        // TODO Auto-generated method stub

    }

}