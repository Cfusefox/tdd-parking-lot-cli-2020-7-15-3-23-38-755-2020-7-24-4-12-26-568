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
        this.errorMessage = null;
        float maxPercentage = maxPercentageOfUseableVolume(parkingLots);
        for (ParkingLot parkingLot: parkingLots) {
            if((parkingLot.getVolume() - parkingLot.getParkingRoom().size()) / (float) parkingLot.getVolume()  == maxPercentage) {
                CarTicket carTicket = parkingLot.park(car);
                if(carTicket != null) {
                    return carTicket;
                }
                this.errorMessage = parkingLot.getErrorMessage();
            }
        }
        return null;
    }

    @Override
    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot: parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if(car != null) {
                return car;
            }
            this.errorMessage = parkingLot.getErrorMessage();
        }
        return null;
    }

    @Override
    public String answerCustomerMessage(CarTicket carTicket) {
        if(this.errorMessage != null) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

    private float maxPercentageOfUseableVolume(ArrayList<ParkingLot> parkingLots) {
        float max = 0;
        for (ParkingLot parkingLot: parkingLots) {
            int nullVolume = parkingLot.getVolume() - parkingLot.getParkingRoom().size();
            if(max < nullVolume / (float) parkingLot.getVolume()) {
                max = nullVolume / (float) parkingLot.getVolume();
            }
        }
        return max;
    }
}
