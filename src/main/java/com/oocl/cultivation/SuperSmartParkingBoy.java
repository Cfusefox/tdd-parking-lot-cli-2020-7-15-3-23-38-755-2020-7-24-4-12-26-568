package com.oocl.cultivation;

import java.util.ArrayList;

public class SuperSmartParkingBoy implements ParkingBoy{

    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.errorMessage = null;
    }

    @Override
    public CarTicket parkingCar(Car car) {
        return null;
    }

    @Override
    public Car fetchCar(CarTicket carTicket) {
        return null;
    }

    @Override
    public String answerCustomerMessage(CarTicket carTicket) {
        return null;
    }
}
