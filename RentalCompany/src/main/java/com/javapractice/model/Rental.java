package com.javapractice.model;

import com.javapractice.utility.DbReader;

public interface Rental {

    public static final DbReader db = DbReader.getInstance();

    public boolean checkInfo();
    public void calculateFee(int vehicleQty, int timeQty);
    public Double getFee();
    public Integer getQty();
}