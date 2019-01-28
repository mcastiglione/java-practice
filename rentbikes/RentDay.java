package com.intivefdv.backend;

import java.util.HashMap;

public class RentDay implements Rental {

	private Double fee;

	private Integer bikes;

	private Integer days;

	private Integer costPerDay = 20;

	public RentDay(int bikes, int days) {
		this.bikes = bikes;
		this.days = days;
	}

	@Override
	public boolean checkInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void calculateFee() {
		this.fee = bikes.doubleValue()*days.doubleValue()*costPerDay.doubleValue();
	}

	@Override
	public Double getFee() {
		return this.fee;
	}

	public Integer getBikes() {
		return this.bikes;
	}

	public Integer getDays() {
		return this.days;
	}

	public Integer getCostPerDay() {
		return this.costPerDay;
	}

	@Override
	public String toString() {
		return new String("You will rent " + this.bikes + " bikes for " + this.days + " days for a total fee of " + this.fee);
	}
}
