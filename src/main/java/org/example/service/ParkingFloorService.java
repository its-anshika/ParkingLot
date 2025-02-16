package org.example.service;

import org.example.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloorService {

    static int getFreeSlotsCount( Floor parkingFloor,VehicleType vehicleType){
        List<Slot> parkingSlotList=parkingFloor.getListOfSlots();
        int count=0;
        for(Slot slot: parkingSlotList){
            if(slot.isAvailable() && slot.getSlotType() == vehicleType)
                count++;
        }
        return count;
    }
    ParkingSlotService parkingSlotService;
    static Ticket allotSlot(Floor parkingFloor, Vehicle vehicle) {
        VehicleType vehType = vehicle.getType();
        List<Slot> availableParkingSlots = new ArrayList<>();
        List<Slot> parkingSlotList = parkingFloor.getListOfSlots();

        //get free slot of this type on this floor
        for (Slot slot : parkingSlotList) {
            if (slot.isAvailable() && slot.getSlotType() == vehType)
                availableParkingSlots.add(slot);
        }
        if (!availableParkingSlots.isEmpty()) {
            Slot parkingSlot = availableParkingSlots.get(0); //first free slot
            ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlot);
            return parkingSlotService.allotSlot(parkingSlot, vehicle);
        }
        return null;
    }
}
