package com.intivefdv.backend;

import java.util.HashMap;

public class RentHour implements Rental {

	public Double fee;
	
	Integer bikes;
	
	Integer hours;
	
	Integer costPerHour;
	
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
	
	public RentHour(HashMap<String, Integer> details) {
		this.bikes = details.get("bikes");
		this.hours = details.get("hours");
		this.costPerHour = details.get("costPerHour");
		this.fee = calculateFee();
	}
	

}
