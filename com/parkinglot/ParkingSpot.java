package com.parkinglot;

public class ParkingSpot {
    private int spotId;
    private boolean isAvailable = true;
    private VehicleType spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
    }

    public synchronized boolean assignVehicle(Vehicle vehicle){
        if(isAvailable() && canFitVehicle(vehicle.getVehicleType())){
            this.parkedVehicle=vehicle;
            this.isAvailable=false;
            return true;
        }
        return false;
    }

    public synchronized void removeVehicle(){
        this.isAvailable=true;
        this.parkedVehicle=null;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public int getSpotId(){
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean canFitVehicle(VehicleType vehicleType){
        if(this.spotType==VehicleType.Truck){
            return true;
        }
        else if(this.spotType==VehicleType.Car){
            return vehicleType==VehicleType.Car || vehicleType==VehicleType.Bike;
        }
        else{
            return vehicleType==VehicleType.Bike;
        }
    }


}
