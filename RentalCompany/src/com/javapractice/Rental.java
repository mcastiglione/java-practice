package com.javapractice;

interface Rental {
    public boolean checkInfo();
    public void calculateFee();
    public Double getFee();
    public Integer getRentalQty();
    public Integer getTime();
    public void readConfig(String string);
}