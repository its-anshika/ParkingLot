package org.example.entities;

public class Vehicle {
    VehicleType type;
    private String number;
    private String color;

    public Vehicle(VehicleType type, String number, String color){
        this.type=type;
        this.number=number;
        this.color=color;
    }
    public String getNumber() {
        return this.number;
    }
    public String getColor(){
        return this.color;
    }
    public VehicleType getType(){
        return this.type;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
