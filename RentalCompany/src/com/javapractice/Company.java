package com.javapractice;

import java.util.ArrayList;

import com.javapractice.FamilyRental;
import com.javapractice.RentalFactory;
import com.javapractice.Rental;

public class Company {
    private static Rental rental;
    private static ArrayList<RentData> rentals;
    private static RentalFactory rentalFactory;

    public static void main(String[] args) {

        rentalFactory = new RentalFactory();

        //Case hour
        rental = rentalFactory.newRental("bike", "hour", 1,1);

        //Case day
        rental = rentalFactory.newRental("bike", "day", 1,2);

        //Case week
        rental = rentalFactory.newRental( "bike", "week", 1,1);

        //Case family
        rentals = new ArrayList<RentData>();

        RentData fRentalHourData = new RentData("car", "hour", 1,3);

        RentData fRentalDayData = new RentData("bike", "day", 1,5);

        RentData fRentalWeekData = new RentData("car", "week", 2,10);

        rentals.add(fRentalHourData);
        rentals.add(fRentalDayData);
        rentals.add(fRentalWeekData);

        int discount = 30;

        rental = rentalFactory.newFamilyRental(rentals, discount);

        System.out.println(rental);
    }
}