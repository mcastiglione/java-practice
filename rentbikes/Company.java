package com.intivefdv.backend;

import com.intivefdv.backend.*;

import java.util.HashMap;

public class Company {
	private static Rental rental;

	public static void main(String[] args) {

		HashMap data;

		Integer costPerHour = 5;
		Integer costPerDay = 20;
		Integer costPerWeek = 60;

		//Case hour
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("hours", 1);
		data.put("costPerHour", costPerHour);

		rental = new RentHour(data);
		System.out.println(rental.toString());


		//Case day
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("days", 2);
		data.put("costPerDay", costPerDay);

		rental = new RentDay(data);
		System.out.println(rental.toString());


		//Case week
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("weeks", 1);
		data.put("costPerWeek", costPerWeek);

		rental = new RentWeek(data);
		System.out.println(rental.toString());



		//Case family
		data = new HashMap<String,Integer>();
		data.put("bikesHour", 1);
		data.put("bikesDay", 1);
		data.put("bikesWeek", 2);

		data.put("hours", 3);
		data.put("days", 5);
		data.put("weeks", 10);

		data.put("costPerHour", costPerHour);
		data.put("costPerDay", costPerDay);
		data.put("costPerWeek", costPerWeek);

		data.put("discount", 10);

		rental = new FamilyRental(data);
		System.out.println(rental.toString());

	}
}
