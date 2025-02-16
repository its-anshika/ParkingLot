package org.example.entities;

public class Slot {
    VehicleType vehicleType;
    private boolean isAvailable;
    private int slotNumber;
    private int floorNumber;
    public Slot(VehicleType type, boolean isAvailable, int slotNumber, int floorNumber){
        this.isAvailable = isAvailable;
        this.slotNumber = slotNumber;
        this.vehicleType = type;
        this.floorNumber = floorNumber;
    }
    Ticket ticket;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }
    public VehicleType getSlotType() {
        return this.vehicleType;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
    public int getSlotNumber(){
        return this.slotNumber;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
