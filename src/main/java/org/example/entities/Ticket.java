package org.example.entities;

public class Ticket {
    String id;
    Vehicle vehicle;
    Slot parkingSlot;

    public Ticket(String id, Slot parkingSlot, Vehicle vehicle) {
        this.id = id;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(Slot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
