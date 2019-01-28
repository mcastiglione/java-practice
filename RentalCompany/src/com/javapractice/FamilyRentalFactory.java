package com.javapractice;

import java.util.ArrayList;

public class FamilyRentalFactory {
    Rental rental;
    FamilyRental familyRental;

    public FamilyRentalFactory() {

    }

    public Rental newRental(ArrayList<RentData> data, int discount) {

        ArrayList<Rental> rentals = new ArrayList<Rental>();

        String vehicleType;
        String timeUnit;
        Integer rentalQty;
        Integer timeQty;

        for (int x = 0; x < data.size(); x++) {
            RentData rentalData = data.get(x);
            vehicleType = rentalData.getVehicleType();
            timeUnit = rentalData.getTimeUnit();
            rentalQty = rentalData.getRentalQty();
            timeQty = rentalData.getTimeQty();


            switch(vehicleType) {
                case "car":
                    switch(timeUnit) {
                        case "hour":
                            rental = new RentCarHour(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                        case "day":
                            rental = new RentCarDay(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                        case "week":
                            rental = new RentCarWeek(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                    }
                    break;
                case "bike":
                    switch(timeUnit) {
                        case "hour":
                            rental = new RentBikeHour(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                        case "day":
                            rental = new RentBikeDay(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                        case "week":
                            rental = new RentBikeWeek(rentalQty, timeQty);
                            rental.calculateFee();
                            break;
                    }
            }
            rentals.add(rental);
        }

        familyRental = new FamilyRental(rentals, discount);
        familyRental.calculateFee();

        return familyRental;
    }
}
