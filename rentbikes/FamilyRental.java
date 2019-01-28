package com.intivefdv.backend;

import java.util.ArrayList;
import com.intivefdv.backend.Rental;
import com.intivefdv.backend.RentHour;
import com.intivefdv.backend.RentDay;
import com.intivefdv.backend.RentWeek;

public class FamilyRental implements Rental {

	private Double fee = 0.0;

	private ArrayList<Rental> rentals;
	
	private Integer discount;

	public FamilyRental(ArrayList<Rental> rentals, int discount) {
		this.rentals = rentals;
		this.discount = discount;
	}

	@Override
	public boolean checkInfo() {
		return true;
	}

	@Override
	public void calculateFee() {
		rentals.stream().forEach(y->fee += y.getFee());
		fee = fee - (fee/100*discount.doubleValue());
	}

	@Override
	public Double getFee() {
		return fee;
	}

	@Override
	public String toString() {
		String returnString = new String("Family Rental total cost: " + fee);
		return returnString;
	}
}
