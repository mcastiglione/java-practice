package com.javapractice;

import com.javapractice.model.Rental;
import com.javapractice.model.FamilyRental;
import com.javapractice.utility.RentalFactory;
import com.javapractice.utility.RentFamily;

import java.util.ArrayList;

public class Company {
    private static Rental rental;
    private static FamilyRental fRental;
    private static ArrayList<Rental> rentals;
    private static RentalFactory rentalFactory;

    public static void main(String[] args) {

        rentalFactory = new RentalFactory();

        //Case hour
        rental = rentalFactory.newRental("bike", "hour");
        rental.calculateFee(1,1);

        //Case day
        rental = rentalFactory.newRental("bike", "day");
        rental.calculateFee(1,2);

        //Case week
        rental = rentalFactory.newRental( "bike", "week");
        rental.calculateFee(1,1);

        //Case family
        rentals = new ArrayList<Rental>();

        Rental fRentalHour = rentalFactory.newRental("car", "hour");
        fRentalHour.calculateFee(1,3);

        Rental fRentalDay = rentalFactory.newRental("bike", "day");
        fRentalDay.calculateFee(1,5);

        Rental fRentalWeek = rentalFactory.newRental("car", "week");
        fRentalWeek.calculateFee(2,10);

        rentals.add(fRentalHour);
        rentals.add(fRentalDay);
        rentals.add(fRentalWeek);

        int discount = 30;

        fRental = new RentFamily();
        fRental.calculateFee(rentals, discount);

        System.out.println(fRental);
    }
}