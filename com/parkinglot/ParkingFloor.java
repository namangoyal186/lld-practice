package com.parkinglot;

import java.util.*;

public class ParkingFloor {
    Map<VehicleType,Queue<ParkingSpot>> availableSpotsMap;

    private int floorNumber;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpotList){
        this.floorNumber=floorNumber;
        this.availableSpotsMap=new HashMap<>();

        availableSpotsMap.put(VehicleType.Truck,new LinkedList<>());
        availableSpotsMap.put(VehicleType.Car,new LinkedList<>());
        availableSpotsMap.put(VehicleType.Bike,new LinkedList<>());

        for(ParkingSpot spot:parkingSpotList){
            availableSpotsMap.get(spot.getSpotType()).offer(spot);
        }
    }

    public synchronized ParkingSpot assignSpotForVehicle(Vehicle vehicle){
        List<VehicleType> validSpotType = getCompatibleSpotTypes(vehicle.getVehicleType());

        for(VehicleType spotType:validSpotType){
            Queue<ParkingSpot> queue = availableSpotsMap.get(spotType);
            if(queue!=null && !queue.isEmpty()){
                ParkingSpot spot = queue.poll();
                if(spot.assignVehicle(vehicle)){
                    return spot;
                }
            }
        }
        return null;
    }

    public synchronized void releaseSpot(ParkingSpot parkingSpot){
        parkingSpot.removeVehicle();
        availableSpotsMap.get(parkingSpot.getSpotType()).offer(parkingSpot);
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<VehicleType> getCompatibleSpotTypes(VehicleType vehicleType){
        List<VehicleType> types = new ArrayList<>();
        switch (vehicleType){
            case Bike:
                types.add(VehicleType.Bike);
                types.add(VehicleType.Car);
                types.add(VehicleType.Truck);
                break;
            case Car:
                types.add(VehicleType.Car);
                types.add(VehicleType.Truck);
                break;
            case Truck:
                types.add(VehicleType.Truck);
                break;
        }
        return types;
    }

    public void printAvailabilityStatus(){
        System.out.println("Floor Number : " + getFloorNumber() + " Availability Status");
        for(Map.Entry<VehicleType,Queue<ParkingSpot>> entry:availableSpotsMap.entrySet()){
            System.out.println(entry.getKey() + "Spots free : " + entry.getValue().size());
        }
    }
}
