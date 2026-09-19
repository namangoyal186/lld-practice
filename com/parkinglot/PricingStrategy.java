package com.parkinglot;

public interface PricingStrategy {
    double calculateFee(ParkingTicket ticket);
}
