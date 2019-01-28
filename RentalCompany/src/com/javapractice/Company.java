package com.javapractice;

import java.util.ArrayList;

import com.javapractice.FamilyRental;
import com.javapractice.Rent;
import com.javapractice.Rental;

public class Company {
    private static Rental rental;

    public static void main(String[] args) {
        //Case hour
        rental = new Rent(1,1, "hour", "bike");
        rental.readConfig("config.properties");
        rental.calculateFee();

        //Case day
        rental = new Rent(1,2, "day", "bike");

        rental.readConfig("config.properties");
        rental.calculateFee();

        //Case week
        rental = new Rent(1,1, "week", "bike");
        rental.readConfig("config.properties");
        rental.calculateFee();

        //Case family
        ArrayList<Rental> rentals = new ArrayList<Rental>();

        Rental fRentalHour = new Rent(1,3, "hour", "bike");
        fRentalHour.readConfig("config.properties");
        fRentalHour.calculateFee();

        Rental fRentalDay = new Rent(1,5, "day", "bike");
        fRentalDay.readConfig("config.properties");
        fRentalDay.calculateFee();

        Rental fRentalWeek = new Rent(2,10, "week", "bike");
        fRentalWeek.readConfig("config.properties");
        fRentalWeek.calculateFee();

        rentals.add(fRentalHour);
        rentals.add(fRentalDay);
        rentals.add(fRentalWeek);

        int discount = 30;

        rental = new FamilyRental(rentals, discount);
        rental.calculateFee();
        System.out.println(rental);
    }
}