package com.oocl.cultivation;


import java.util.ArrayList;

public class SmartParkingBoy extends GeneralParkingBoy {
    private String errorMessage;


    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {
        this.errorMessage = "";
        int maxNullVolume = maxVolumeNumber(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVolume() - parkingLot.getParkingRoom().size() == maxNullVolume) {
                CarTicket carTicket = parkingLot.parkingCar(car);
                if (carTicket != null) {
                    return carTicket;
                }
            }
        }
        this.errorMessage += "Not enough position.";
        return null;
    }

    @Override
    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if (car != null) {
                return car;
            }
            this.errorMessage = "Unrecognized parking ticket.";
        }
        return null;
    }

    private int maxVolumeNumber(ArrayList<ParkingLot> parkingLots) {
        int max = 0;
        for (ParkingLot parkingLot : parkingLots) {
            int nullVolume = parkingLot.getVolume() - parkingLot.getParkingRoom().size();
            if (max < nullVolume) {
                max = nullVolume;
            }
        }
        return max;
    }

    @Override
    public String answerCustomerMessage(CarTicket carTicket) {
        if (!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
