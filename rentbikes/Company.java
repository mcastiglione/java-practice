package com.intivefdv.backend;

import com.intivefdv.backend.Rental;
import com.intivefdv.backend.RentHour;
import com.intivefdv.backend.RentDay;
import com.intivefdv.backend.RentWeek;
import com.intivefdv.backend.FamilyRental;

import java.util.HashMap;

public class Company {
	private static Rental rental;

	public static void main(String[] args) {

		HashMap data;

		//Case hour
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("hours", 1);

		rental = new RentHour(data);
		System.out.println(rental.toString());


		//Case day
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("days", 2);

		rental = new RentDay(data);
		System.out.println(rental.toString());


		//Case week
		data = new HashMap<String,Integer>();
		data.put("bikes", 1);
		data.put("weeks", 1);

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

		data.put("discount", 10);

		rental = new FamilyRental(data);
		System.out.println(rental.toString());

	}
}
