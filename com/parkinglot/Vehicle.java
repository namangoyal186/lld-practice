package com.parkinglot;

public abstract class Vehicle {
    protected String licenseNumber;
    protected VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


}

class Bike extends Vehicle{

    public Bike(String licenseNumber) {
        super(licenseNumber, VehicleType.Bike);
    }
}

class Car extends Vehicle{

    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.Car);
    }
}

class Truck extends Vehicle{

    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.Truck);
    }
}
