package com.parkinglot;
import java.util.*;

public class ParkingLot {
    private List<ParkingFloor> parkingFloorList;
    private static ParkingLot parkingLotInstance;

    private ParkingLot(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public static synchronized ParkingLot getInstance(List<ParkingFloor> parkingFloorList){
        if(parkingLotInstance==null){
            parkingLotInstance=new ParkingLot(parkingFloorList);
        }
        return parkingLotInstance;
    }

    public synchronized ParkingTicket assignTicket(Vehicle vehicle){
        for(ParkingFloor floor:parkingFloorList){
            ParkingSpot spot = floor.assignSpotForVehicle(vehicle);
            if(spot!=null){
                String ticketId = UUID.randomUUID().toString();
                System.out.println("Vehicle " + vehicle.getLicenseNumber() + " parked at floor " + floor.getFloorNumber()
                + " at Spot " + spot.getSpotId());
                return new ParkingTicket(ticketId,vehicle,spot,floor);
            }
        }
        throw new SpotNotAvailableException("Sorry! No available spots left for vehicle type: " + vehicle.getVehicleType());
    }

    public synchronized void vacateSpot(ParkingTicket parkingTicket, PricingStrategy pricingStrategy){
        ParkingFloor floor = parkingTicket.getParkingFloor();
        floor.releaseSpot(parkingTicket.getParkingSpot());
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment(parkingTicket,pricingStrategy);
        System.out.println("Vehicle "+ parkingTicket.getVehicle().getLicenseNumber() + " exited successfully");
    }



}
