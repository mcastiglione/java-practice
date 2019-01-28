package com.javapractice;

import java.util.ArrayList;

public class RentalFactory {

    Rental rental;

    public RentalFactory() {

    }

    public Rental newRental(String vehicleType, String timeUnit, int rentalQty, int timeQty) {
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
    return rental;
    }
}
