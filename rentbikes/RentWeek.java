package com.intivefdv.backend;

import java.util.HashMap;

public class RentWeek implements Rental {
	
	public Double fee;
	
	Integer bikes;
	
	Integer weeks;
	
	Integer costPerWeek;
	
	@Override
	public boolean checkInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double calculateFee() {
		this.fee = bikes.doubleValue()*weeks.doubleValue()*costPerWeek.doubleValue();
		return fee;
	}
	
	public Double getFee() {
		return fee;
	}

	@Override
	public String toString() {
		return new String("You will rent " + bikes + " bikes for " + weeks + " weeks for a total fee of " + fee);
	}
	
	public RentWeek(HashMap<String, Integer> details) {
		this.bikes = details.get("bikes");
		this.weeks = details.get("weeks");
		this.costPerWeek = details.get("costPerWeek");
		this.fee = calculateFee();
	}
}
