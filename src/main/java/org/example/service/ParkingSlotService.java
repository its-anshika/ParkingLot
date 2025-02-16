package org.example.service;

import org.example.entities.Slot;
import org.example.entities.Ticket;
import org.example.entities.Vehicle;

public class ParkingSlotService {
    Slot slot;
    public ParkingSlotService(Slot slot){
        this.slot=slot;
    }
    boolean getStatus(Slot slot){
        return slot.isAvailable();
    }
    public Ticket allotSlot(Slot slot, Vehicle vehicle){
        slot.setAvailable(false);
        String ticketId = slot.getFloorNumber() + "_" + slot.getSlotNumber() +"_" + vehicle.getNumber();
        Ticket ticket = new Ticket(ticketId, slot, vehicle);
        slot.setTicket(ticket);//
        return ticket;
    }
    public void unallotSlot(Slot slot, Vehicle vehicle){
        slot.setAvailable(true);
        slot.setTicket(null);//
    }
}
