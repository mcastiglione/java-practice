package com.javapractice;

import com.javapractice.model.Rental;
import com.javapractice.model.FamilyRental;
import com.javapractice.utility.RentalFactory;
import com.javapractice.utility.RentFamily;
import com.javapractice.utility.DbReader;

import java.util.ArrayList;

public class Company {
    private static Rental rental;
    private static FamilyRental fRental;
    private static ArrayList<Rental> rentals;
    private static RentalFactory rentalFactory;

    public static void main(String[] args) {

        DbReader dbReader = DbReader.getInstance();

        rentalFactory = new RentalFactory();

        //Case hour
        rental = rentalFactory.getRental("bike", "hour");
        rental.calculateFee(1,1);
        System.out.println(rental);

        //Case day
        rental = rentalFactory.getRental("bike", "day");
        rental.calculateFee(1,2);
        System.out.println(rental);

        //Case week
        rental = rentalFactory.getRental( "bike", "week");
        rental.calculateFee(1,1);
        System.out.println(rental);

        //Case family
        rentals = new ArrayList<Rental>();

        System.out.println("BEGIN family rental rentals");

        Rental fRentalHour = rentalFactory.getRental("car", "hour");
        fRentalHour.calculateFee(1,3);
        System.out.println(fRentalHour);


        Rental fRentalDay = rentalFactory.getRental("bike", "day");
        fRentalDay.calculateFee(1,5);
        System.out.println(fRentalDay);

        Rental fRentalWeek = rentalFactory.getRental("car", "week");
        fRentalWeek.calculateFee(2,10);
        System.out.println(fRentalWeek);

        rentals.add(fRentalHour);
        rentals.add(fRentalDay);
        rentals.add(fRentalWeek);

        int discount = 30;
        System.out.println("Family discount: " + discount + "%");
        fRental = new RentFamily();
        fRental.calculateFee(rentals, discount);

        System.out.println(fRental);
    }
}