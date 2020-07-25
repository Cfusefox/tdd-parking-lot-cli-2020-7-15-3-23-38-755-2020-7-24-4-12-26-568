package com.oocl.cultivation;

import java.util.ArrayList;

public class GeneralParkingBoy implements ParkingBoy{


    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;

    public GeneralParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
        this.errorMessage = null;
    }

    public CarTicket parkingCar(Car car) {
        this.errorMessage = null;
        for (ParkingLot parkingLot: parkingLots) {
            CarTicket carTicket = parkingLot.park(car);
            if(carTicket != null) {
                return carTicket;
            }
            this.errorMessage = parkingLot.getErrorMessage();
        }
        return null;
    }

    public Car fetchCar(CarTicket carTicket) {
        if(carTicket == null) {
            return null;
        } else {
            for (ParkingLot parkingLot: parkingLots) {
                Car car = parkingLot.fetch(carTicket);
                if(car != null) {
                    return car;
                }
                this.errorMessage = parkingLot.getErrorMessage();
            }
        }
        return null;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if(this.errorMessage != null) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
