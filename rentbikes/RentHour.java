package com.intivefdv.backend;

import java.util.HashMap;

public class RentHour implements Rental {

	private Double fee;

	private Integer bikes;

	private Integer hours;

	private Integer costPerHour = 5;

	public RentHour(int bikes, int hours) {
		this.bikes = bikes;
		this.hours = hours;
	}

	@Override
	public boolean checkInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calculateFee() {
		this.fee = bikes.doubleValue()*hours.doubleValue()*costPerHour.doubleValue();
	}

	@Override
	public Double getFee() {
		return fee;
	}
	
	public Integer getBikes() {
		return bikes;
	}
	
	public Integer getHours() {
		return hours;
	}
	
	public Integer getCostPerHour() {
		return costPerHour;
	}

	@Override
	public String toString() {
		return new String("You will rent " + bikes + " bikes for " + hours + " hours for a total fee of " + fee);
	}
}
