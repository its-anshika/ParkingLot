package org.example;

import org.example.entities.Floor;
import org.example.entities.Vehicle;
import org.example.entities.VehicleType;
import org.example.service.ParkingLotService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Parking Lot!");
        Vehicle v1 = new Vehicle(VehicleType.Car, "12", "blue");
        Vehicle v2 = new Vehicle(VehicleType.Bike, "34", "red");

        ParkingLotService parkingLotService = new ParkingLotService();
        parkingLotService.createParkingLot();
        parkingLotService.park(v1);
        parkingLotService.park(v2);

        parkingLotService.unpark(v2);
    }
}