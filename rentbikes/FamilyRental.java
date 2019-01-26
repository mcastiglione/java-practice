package com.intivefdv.backend;

import java.util.HashMap;

public class FamilyRental implements Rental {

	public Double fee;
	
	Integer bikesHour;
	Integer bikesDay;
	Integer bikesWeek;
	
	Integer hours;
	Integer days;
	Integer weeks;

	Integer costPerHour;
	Integer costPerDay;
	Integer costPerWeek;

	Integer discount;
	
	@Override
	public boolean checkInfo() {
		Integer qty = bikesHour+bikesDay+bikesWeek;
		if (qty > 5) {
			return false;
		}
		
		return true;
	}

	@Override
	public Double calculateFee() {
		Double feeHours = bikesHour.doubleValue()*hours.doubleValue()*costPerHour.doubleValue();
		Double feeDays = bikesDay.doubleValue()*days.doubleValue()*costPerDay.doubleValue();
		Double feeWeeks = bikesWeek.doubleValue()*weeks.doubleValue()*costPerWeek.doubleValue();
		
		Double totalFee = feeHours + feeDays + feeWeeks;

		totalFee = totalFee - (totalFee/100*discount);
		
		return totalFee;
	}

	@Override
	public Double getFee() {
		return fee;
	}
	
	@Override
	public String toString() {
		String returnString = new String("Family Rent: " + 
										   "\n BikesHour: "	+ bikesHour		+ ", hours (per bike): "	+ hours +	", cost per hour:"	+ costPerHour 
										+ ".\n BikesDay: " 	+ bikesDay		+ ", days (per bike): "	+ days +	", cost per day:"	+ costPerDay
										+ ".\n BikesWeek: "	+ bikesWeek		+ ", weeks (per bike): "	+ weeks +	", cost per week:"	+ costPerWeek
										+ ".\n Family discount: "	+ discount
										+ ".\n Total cost: " + fee
				);
		return returnString;
	}
	
	public FamilyRental(HashMap<String, Integer> details) {
		this.bikesHour = details.get("bikesHour");
		this.bikesDay = details.get("bikesDay");
		this.bikesWeek = details.get("bikesWeek");
		
		this.hours = details.get("hours");
		this.days = details.get("days");
		this.weeks = details.get("weeks");

		this.costPerHour = details.get("costPerHour");
		this.costPerDay = details.get("costPerDay");
		this.costPerWeek = details.get("costPerWeek");
		
		this.discount = details.get("discount");
		this.fee = calculateFee();
	}
}
