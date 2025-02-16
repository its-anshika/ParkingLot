package org.example.service;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ParkingLotService {
    List<ParkingLot> parkingLotList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    HashMap<String, Ticket> vehTicketMap = new HashMap<>();
    HashMap<String, Ticket> ticketMap = new HashMap<>();

    public void createParkingLot() {
        System.out.println("Enter the number of floors & number of slots per floor");
        int numberOfFloors = scan.nextInt(), id = 1;
        int numSlots = scan.nextInt();
        List<Floor> parkingFloorList=new ArrayList<>(numberOfFloors);
        for (int i=0;i<numberOfFloors;i++){
            List<Slot> parkingSlotList=new ArrayList<>(numSlots);
            for (int j=0;j<numSlots;j++){
                Slot parkingSlot=new Slot(VehicleType.Car,true, j+1, i+1);
                if (j==0){
                    parkingSlot.setVehicleType(VehicleType.Truck);
                }else if(j==1 || j==2){
                    parkingSlot.setVehicleType(VehicleType.Bike);
                }
                parkingSlotList.add(parkingSlot);
            }
            Floor parkingFloor=new Floor(i+1,numSlots,parkingSlotList);
            parkingFloorList.add(parkingFloor);
        }
        ParkingLot parkingLot=new ParkingLot("1",numberOfFloors,numSlots,parkingFloorList);
        parkingLotList.add(parkingLot);
    }
   public void park(Vehicle vehicle) {
        ParkingLot parkingLot= parkingLotList.get(0);
       List<Floor> parkingFloorList = parkingLot.getParkingFloorList();
       int parkingFloorIndex = 0;
       int floorFullCount = 0;
       for (Floor parkingFloor : parkingFloorList) {
           parkingFloorIndex++;
           if (ParkingFloorService.getFreeSlotsCount(parkingFloor, vehicle.getType()) > 0) {
               Ticket ticket = ParkingFloorService.allotSlot(parkingFloor, vehicle);
               String ticketid=ticket.getId();
               System.out.println("Parked vehicle, ticketID: " + ticketid + " Vehicle Number: "+ vehicle.getNumber() +" and color: "+vehicle.getColor());
               ticketMap.put(ticketid, ticket);
               vehTicketMap.put(vehicle.getNumber(), ticketMap.get(ticketid));
               break;
           } else {
               floorFullCount++;
           }
           if (floorFullCount == parkingFloorList.size()) {
               System.out.println("Parking Lot Full, Cant park");
           }
       }
   }

    public void unpark(Vehicle vehicle){
        Ticket ticket = vehTicketMap.get(vehicle.getNumber());
        Slot slot = ticket.getParkingSlot();
        ParkingSlotService parkingSlotService = new ParkingSlotService(slot);
        parkingSlotService.unallotSlot(slot,vehicle);
        vehTicketMap.remove(vehicle.getNumber());
        ticketMap.remove(ticket.getId());
        System.out.println("Unparked vehicle with Number: "+ vehicle.getNumber() +" and color: "+vehicle.getColor());
    }
}
