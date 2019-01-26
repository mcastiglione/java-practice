package com.intivefdv.backend;

import java.util.HashMap;

public class RentWeek implements Rental {
	
	public Double fee;

	private Integer bikes;

	private Integer weeks;

	private Integer costPerWeek = 60;

	public RentWeek(HashMap<String, Integer> details) {
		this.bikes = details.get("bikes");
		this.weeks = details.get("weeks");
		this.fee = calculateFee();
	}

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
}
