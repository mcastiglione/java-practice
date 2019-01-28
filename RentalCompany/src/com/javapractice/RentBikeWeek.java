package com.javapractice;

public class RentBikeWeek implements Rental {

    private Double fee;

    private Integer bikes;

    private Integer weeks;

    private Integer costPerWeek = 60;

    public RentBikeWeek(int bikes, int weeks) {
        this.bikes = bikes;
        this.weeks = weeks;
    }

    @Override
    public boolean checkInfo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void calculateFee() {
        this.fee = bikes.doubleValue()*weeks.doubleValue()*costPerWeek.doubleValue();
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