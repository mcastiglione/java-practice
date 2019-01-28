package com.javapractice;

public class RentData {
    private String vehicleType;
    private String timeUnit;
    private Integer rentalQty;
    private Integer timeQty;

    public RentData(String vehicleType, String timeUnit, Integer rentalQty, Integer timeQty){
        this.vehicleType = vehicleType;
        this.timeUnit = timeUnit;
        this.rentalQty = rentalQty;
        this.timeQty = timeQty;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public Integer getRentalQty() {
        return rentalQty;
    }

    public Integer getTimeQty() {
        return timeQty;
    }

}
