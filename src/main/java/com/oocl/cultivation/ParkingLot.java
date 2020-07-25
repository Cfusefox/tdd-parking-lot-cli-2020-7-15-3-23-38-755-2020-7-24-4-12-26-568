package com.oocl.cultivation;

import java.util.HashMap;

public class ParkingLot {

    HashMap<CarTicket, Car> parkingRoom = new HashMap<>();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket(car);
        this.parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return this.parkingRoom.remove(carTicket);
    }
}
