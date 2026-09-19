package com.parkinglot;
import java.util.*;

public class Main {

    public static ParkingTicket handleVehicleArrival(ParkingLot parkingLot, Vehicle vehicle) {
        try {
            ParkingTicket ticket = parkingLot.assignTicket(vehicle);
            return ticket;
        } catch (SpotNotAvailableException e) {
            System.out.println("[GATE ALERT] " + vehicle.getLicenseNumber() + " rejected: " + e.getMessage());
            return null; // Return null if parking failed
        }
    }

    public static void printOverallAvailability(List<ParkingFloor> floors) {
        System.out.println("\n========================================");
        System.out.println("      CURRENT PARKING LOT STATUS        ");
        System.out.println("========================================");
        for (ParkingFloor floor : floors) {
            floor.printAvailabilityStatus();
        }
        System.out.println("========================================\n");
    }
    public static void main(String[] args){
        //Setup Floor 1
        List<ParkingSpot> floor1Spot = Arrays.asList(
                new ParkingSpot(1,VehicleType.Car),
                new ParkingSpot(2,VehicleType.Car),
                new ParkingSpot(3,VehicleType.Car),
                new ParkingSpot(4,VehicleType.Bike),
                new ParkingSpot(5,VehicleType.Bike),
                new ParkingSpot(6,VehicleType.Truck)
                );
        //Setup Floor 2
        List<ParkingSpot> floor2Spot = Arrays.asList(
                new ParkingSpot(1,VehicleType.Bike),
                new ParkingSpot(2,VehicleType.Car),
                new ParkingSpot(3,VehicleType.Truck)
        );

        ParkingFloor floor1 = new ParkingFloor(1,floor1Spot);
        ParkingFloor floor2 = new ParkingFloor(2,floor2Spot);

        List<ParkingFloor> allFlours = Arrays.asList(floor1,floor2);

        ParkingLot parkingLot = ParkingLot.getInstance(allFlours);

        //1. Check overall availability before anyone parks
        printOverallAvailability(allFlours);

        //2. Create sample vehicles
        Vehicle car1 = VehicleFactory.createVehicle(VehicleType.Car,"HR26-HH-0001");
        Vehicle bike1 = VehicleFactory.createVehicle(VehicleType.Bike,"PB15-HH-0002");
        Vehicle truck1 = VehicleFactory.createVehicle(VehicleType.Truck,"MH02-HH-0003");

            ParkingTicket ticket1 = handleVehicleArrival(parkingLot,car1);

            ParkingTicket ticket2 = handleVehicleArrival(parkingLot,bike1);

            printOverallAvailability(allFlours);

            ParkingTicket ticket3 = handleVehicleArrival(parkingLot,truck1);

            printOverallAvailability(allFlours);

            PricingStrategy hourlyPricingStrategy = new HourlyPricingStrategy();

            if(ticket1!=null){
                parkingLot.vacateSpot(ticket1,hourlyPricingStrategy);
            }

            printOverallAvailability(allFlours);

            Vehicle truck2 = VehicleFactory.createVehicle(VehicleType.Truck,"MH024-HH-0003");
            Vehicle truck3 = VehicleFactory.createVehicle(VehicleType.Truck,"MH0288-HH-0003");

            ParkingTicket ticket4 = handleVehicleArrival(parkingLot,truck2);
            ParkingTicket ticket5 = handleVehicleArrival(parkingLot,truck3);

        if(ticket2!=null){
            parkingLot.vacateSpot(ticket2,hourlyPricingStrategy);
        }
        if(ticket3!=null){
            parkingLot.vacateSpot(ticket3,hourlyPricingStrategy);
        }
        if(ticket4!=null){
            parkingLot.vacateSpot(ticket4,hourlyPricingStrategy);
        }
        if(ticket5!=null){
            parkingLot.vacateSpot(ticket5,hourlyPricingStrategy);
        }

            printOverallAvailability(allFlours);

    }
}
