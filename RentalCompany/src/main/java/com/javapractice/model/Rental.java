package com.javapractice.model;

public interface Rental {
    public boolean checkInfo();
    public void calculateFee(int vehicleQty, int timeQty);
    public Double getFee();
    public Integer getQty();
}