package com.parkinglot;

public class PaymentService {
    private PaymentStatus paymentStatus;

    public boolean processPayment(ParkingTicket parkingTicket, PricingStrategy pricingStrategy){
        double fee = pricingStrategy.calculateFee(parkingTicket);
        System.out.println("Parking Fee for Vehicle " + parkingTicket.getVehicle().licenseNumber + " is $" +fee);

        this.paymentStatus = PaymentStatus.COMPLETED;
        return true;
    }
}
