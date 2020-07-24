package com.oocl.cultivation;

public class ParkingLot {
    public CarTicket park(Car car) {
        return new CarTicket(car);
    }

    public Car fetch(CarTicket carTicket) {
        return carTicket.getCar();
    }
}
