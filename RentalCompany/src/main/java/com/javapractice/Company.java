package com.javapractice;

import com.javapractice.model.Rental;
import com.javapractice.model.FamilyRental;
import com.javapractice.utility.RentalFactory;
import com.javapractice.utility.RentFamily;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Company {
    private static Rental rental;
    private static FamilyRental fRental;
    private static ArrayList<Rental> rentals;
    private static RentalFactory rentalFactory;

    final static Logger LOG = LoggerFactory.getLogger(Company.class);

    public static void main(String[] args) {
        rentalFactory = new RentalFactory();

        //Case hour
        rental = rentalFactory.getRental("bike", "hour");
        rental.calculateFee(1,1);

        //Case day
        rental = rentalFactory.getRental("bike", "day");
        rental.calculateFee(1,2);

        //Case week
        rental = rentalFactory.getRental( "bike", "week");
        rental.calculateFee(1,1);

        //Case family
        rentals = new ArrayList<Rental>();

        System.out.println("BEGIN family rental rentals");

        Rental fRentalHour = rentalFactory.getRental("car", "hour");
        fRentalHour.calculateFee(1,3);

        Rental fRentalDay = rentalFactory.getRental("bike", "day");
        fRentalDay.calculateFee(1,5);

        Rental fRentalWeek = rentalFactory.getRental("car", "week");
        fRentalWeek.calculateFee(2,10);

        rentals.add(fRentalHour);
        rentals.add(fRentalDay);
        rentals.add(fRentalWeek);

        int discount = 30;
        LOG.info("Family discount: " + discount + "%");
        fRental = new RentFamily();
        fRental.calculateFee(rentals, discount);


    }
}