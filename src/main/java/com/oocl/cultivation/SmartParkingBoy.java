package com.oocl.cultivation;

import java.util.ArrayList;

public class SmartParkingBoy implements ParkingBoy{

    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.errorMessage = null;
    }

    @Override
    public CarTicket parkingCar(Car car) {
        this.errorMessage = null;
        int maxNullVolume = maxVolumeNumber(parkingLots);
        for (ParkingLot parkingLot: parkingLots) {
            if(parkingLot.getVolume() - parkingLot.getParkingRoom().size() == maxNullVolume) {
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

    private int maxVolumeNumber(ArrayList<ParkingLot> parkingLots) {
        int max = 0;
        for (ParkingLot parkingLot: parkingLots) {
            int nullVolume = parkingLot.getVolume() - parkingLot.getParkingRoom().size();
            if(max < nullVolume) {
                max = nullVolume;
            }
        }
        return max;
    }

}
