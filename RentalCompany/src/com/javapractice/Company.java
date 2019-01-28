package com.javapractice;

import java.util.ArrayList;

import com.javapractice.FamilyRental;
import com.javapractice.RentalFactory;
import com.javapractice.Rental;

public class Company {
    private static Rental rental;

    public static void main(String[] args) {

        RentalFactory rentalFactory = new RentalFactory();
        FamilyRentalFactory familyRentalFactory = new FamilyRentalFactory();

        //Case hour
        rental = rentalFactory.newRental("bike", "hour", 1,1);

        //Case day
        rental = rentalFactory.newRental("bike", "day", 1,2);

        //Case week
        rental = rentalFactory.newRental( "bike", "week", 1,1);

        //Case family
        ArrayList<RentData> rentals = new ArrayList<RentData>();

        RentData fRentalHourData = new RentData("bike", "hour", 1,3);

        RentData fRentalDayData = new RentData("bike", "day", 1,5);

        RentData fRentalWeekData = new RentData("bike", "week", 2,10);

        rentals.add(fRentalHourData);
        rentals.add(fRentalDayData);
        rentals.add(fRentalWeekData);

        int discount = 30;

        rental = familyRentalFactory.newRental(rentals, discount);

        System.out.println(rental);
    }
}