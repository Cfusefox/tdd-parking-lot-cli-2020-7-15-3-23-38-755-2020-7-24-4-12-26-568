package com.oocl.cultivation;

import java.util.ArrayList;

public class SmartParkingBoy implements ParkingBoy{

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
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
