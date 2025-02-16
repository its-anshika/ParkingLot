package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Floor {
//    private int idOfParkingLot;
    private int floorNumber;
    private int noOfSlots;
    List<Slot> listOfSlots= new ArrayList<>();

    public Floor(int floorNumber, int noOfSlots, List<Slot> slots){
        this.floorNumber = floorNumber;
        this.noOfSlots = noOfSlots;
        this.listOfSlots = slots;
    }

    public List<Slot> getListOfSlots() {
        return listOfSlots;
    }
}
