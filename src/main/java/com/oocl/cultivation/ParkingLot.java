package com.oocl.cultivation;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParkingLot {

    private String errorMessage;
    LinkedHashMap<CarTicket, Car> parkingRoom = new LinkedHashMap<>();
    private int volume;

    public ParkingLot(int volume) {
        this.volume = volume;
        this.errorMessage = "";
    }

    public ParkingLot() {
        this.volume = 10;
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getVolume() {
        return volume;
    }

    public CarTicket park(Car car) {
        if(parkingRoom.size() >= this.volume) {
            return null;
        }
        this.errorMessage = "";
        CarTicket carTicket = new CarTicket(car);
        this.parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public LinkedHashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public Car fetch(CarTicket carTicket) {
        this.errorMessage = "";
        if(this.parkingRoom.get(carTicket) == null) {
            this.errorMessage += "Unrecognized parking ticket.";
        }
        return this.parkingRoom.remove(carTicket);
    }

}
