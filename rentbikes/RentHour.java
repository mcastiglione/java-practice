package com.intivefdv.backend;

import java.util.HashMap;

public class RentHour implements Rental {

	public Double fee;
	
	private Integer bikes;
	
	private Integer hours;
	
	private Integer costPerHour = 5;

	public RentHour(HashMap<String, Integer> details) {
		this.bikes = details.get("bikes");
		this.hours = details.get("hours");
		this.fee = calculateFee();
	}

	@Override
	public boolean checkInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double calculateFee() {
		this.fee = bikes.doubleValue()*hours.doubleValue()*costPerHour.doubleValue();
		return fee;
	}

	@Override
	public Double getFee() {
		return fee;
	}

	@Override
	public String toString() {
		return new String("You will rent " + bikes + " bikes for " + hours + " hours for a total fee of " + fee);
	}
}
