package com.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculateFee(ParkingTicket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        hours = Math.max(hours,1);

        switch (ticket.getVehicle().getVehicleType()){
            case Bike:
                return hours*10.0;
            case Car:
                return hours*20.0;
            case Truck:
                return hours*30.0;
            default:
                return hours*15.0;
        }
    }
}
