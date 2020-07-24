package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public CarTicket parkingCar(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        return null;
    }
}
