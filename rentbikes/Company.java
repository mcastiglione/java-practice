package com.intivefdv.backend;

import com.intivefdv.backend.Rental;
import com.intivefdv.backend.RentHour;
import com.intivefdv.backend.RentDay;
import com.intivefdv.backend.RentWeek;
import com.intivefdv.backend.FamilyRental;

import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	private static Rental rental;

	public static void main(String[] args) {

		//Case hour
		rental = new RentHour(1,1);
		rental.calculateFee();

		//Case day
		rental = new RentDay(1,2);
		rental.calculateFee();

		//Case week
		rental = new RentWeek(1,1);
		rental.calculateFee();

		//Case family
		ArrayList<Rental> rentals = new ArrayList<Rental>();
		Rental fRentalHour = new RentHour(1,3);
		fRentalHour.calculateFee();

		Rental fRentalDay = new RentDay(1,5);
		fRentalDay.calculateFee();

		Rental fRentalWeek = new RentWeek(2,10);
		fRentalWeek.calculateFee();
		
		rentals.add(fRentalHour);
		rentals.add(fRentalDay);
		rentals.add(fRentalWeek);

		int discount = 30;

		rental = new FamilyRental(rentals, discount);
		rental.calculateFee();
		System.out.println(rental.getFee());

	}
}
