package com.parkinglot;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String licenseNumber){
        switch (vehicleType){
            case Car:
                return new Car(licenseNumber);
            case Bike:
                return new Bike(licenseNumber);
            case Truck:
                return new Truck(licenseNumber);
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
