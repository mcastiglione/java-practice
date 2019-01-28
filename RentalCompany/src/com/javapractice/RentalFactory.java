package com.javapractice;

import java.util.ArrayList;

public class RentalFactory {

    Rental rental;

    public RentalFactory() {

    }

    public Rental newRental(String vehicleType, String timeUnit) {
        switch(vehicleType) {
            case "car":
                switch(timeUnit) {
                    case "hour":
                        rental = new RentCarHour();
                        break;
                    case "day":
                        rental = new RentCarDay();
                        break;
                    case "week":
                        rental = new RentCarWeek();
                        break;
                }
                break;
            case "bike":
                switch(timeUnit) {
                    case "hour":
                        rental = new RentBikeHour();
                        break;
                    case "day":
                        rental = new RentBikeDay();
                        break;
                    case "week":
                        rental = new RentBikeWeek();
                        break;
                }
        }
    return rental;
    }
}
