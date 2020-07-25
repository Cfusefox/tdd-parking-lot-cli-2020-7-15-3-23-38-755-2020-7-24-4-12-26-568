package com.oocl.cultivation;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParkingLot {

    private String errorMessage;
    LinkedHashMap<CarTicket, Car> parkingRoom = new LinkedHashMap<>();

    public String getErrorMessage() {
        return errorMessage;
    }

    public CarTicket park(Car car) {
        if(parkingRoom.size() >= 10) {
            this.errorMessage = "Not enough position.";
            return null;
        }
        this.errorMessage = null;
        CarTicket carTicket = new CarTicket(car);
        this.parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public LinkedHashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public Car fetch(CarTicket carTicket) {
        this.errorMessage = null;
        if(this.parkingRoom.get(carTicket) == null) {
            this.errorMessage = "Unrecognized parking ticket.";
        }
        return this.parkingRoom.remove(carTicket);
    }

}
