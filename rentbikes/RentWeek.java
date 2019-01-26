package com.intivefdv.backend;

import java.util.HashMap;

public class RentWeek implements Rental {

	private Double fee;

	private Integer bikes;

	private Integer weeks;

	private Integer costPerWeek = 60;

	public RentWeek(int bikes, int weeks) {
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
		return fee;
	}
	
	public Integer getBikes() {
		return bikes;
	}
	
	public Integer getWeeks() {
		return weeks;
	}
	
	public Integer getCostPerWeek() {
		return costPerWeek;
	}

	@Override
	public String toString() {
		return new String("You will rent " + bikes + " bikes for " + weeks + " weeks for a total fee of " + fee);
	}
}
