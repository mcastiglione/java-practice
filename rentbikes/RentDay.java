package com.intivefdv.backend;

import java.util.HashMap;

public class RentDay implements Rental {

	public Double fee;
	
	private Integer bikes;

	private Integer days;

	private Integer costPerDay = 20;

	public RentDay(HashMap<String, Integer> details) {
		this.bikes = details.get("bikes");
		this.days = details.get("days");
		this.fee = calculateFee();
	}

	@Override
	public boolean checkInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double calculateFee() {
		this.fee = bikes.doubleValue()*days.doubleValue()*costPerDay.doubleValue();
		return fee;
	}

	@Override
	public Double getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		return new String("You will rent " + bikes + " bikes for " + days + " days for a total fee of " + fee);
	}
}
