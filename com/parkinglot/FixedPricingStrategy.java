package com.parkinglot;

public class FixedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFee(ParkingTicket ticket) {
        switch (ticket.getVehicle().getVehicleType()){
            case Bike:
                return 5.0;
            case Car:
                return 10.0;
            case Truck:
                return 15.0;
            default:
                return 7.5;
        }
    }
}
