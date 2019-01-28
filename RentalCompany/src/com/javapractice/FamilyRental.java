package com.javapractice;

import java.util.ArrayList;

public class FamilyRental implements Rental {

    private Double fee = 0.0;

    private ArrayList<Rental> rentals;

    private Integer discount;

    private Integer Qty = 0;

    public FamilyRental(ArrayList<Rental> rentals, int discount) {
        this.rentals = rentals;
        this.discount = discount;
    }

    @Override
    public boolean checkInfo() {
        if (Qty > 5 || Qty < 3) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void calculateFee() {
        rentals.stream().forEach(y->this.fee += y.getFee());
        this.fee = this.fee - (this.fee/100*discount.doubleValue());

        rentals.stream().forEach(y->this.Qty += y.getQty());
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