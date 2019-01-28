package com.javapractice;

import java.util.ArrayList;

interface FamilyRental {
    public boolean checkInfo();
    public void calculateFee(ArrayList<Rental> rentals, int discount);
    public Double getFee();
    public Integer getQty();
}