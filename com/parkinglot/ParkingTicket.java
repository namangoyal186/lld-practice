package com.parkinglot;

import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketId;
    LocalDateTime entryTime;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    ParkingFloor parkingFloor;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot,ParkingFloor parkingFloor) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime=LocalDateTime.now();
        this.parkingFloor=parkingFloor;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


}
