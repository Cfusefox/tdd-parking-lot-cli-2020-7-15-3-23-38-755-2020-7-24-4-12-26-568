package com.oocl.cultivation;

import com.oocl.cultivation.ParkingCarBehavior.SuperSmartParkingCarBehavior;

import java.util.ArrayList;

public class SuperSmartParkingBoy implements ParkingBoy {

    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;
    private ParkingCarBehavior parkingCarBehavior;

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.errorMessage = null;
        this.parkingCarBehavior = new SuperSmartParkingCarBehavior();
    }

    @Override
    public CarTicket parkingCar(Car car) {
        this.errorMessage = null;
        CarTicket carTicket = parkingCarBehavior.parkingCar(car, parkingLots);
        if (carTicket != null) {
            return carTicket;
        } else {
            this.errorMessage = "Not enough position.";
            return null;
        }
    }

    @Override
    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if (car != null) {
                return car;
            }
            this.errorMessage = parkingLot.getErrorMessage();
        }
        return null;
    }

    @Override
    public String answerCustomerMessage(CarTicket carTicket) {
        if (this.errorMessage != null) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
