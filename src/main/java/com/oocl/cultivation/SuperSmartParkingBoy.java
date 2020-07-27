package com.oocl.cultivation;


import java.util.ArrayList;

public class SuperSmartParkingBoy extends SmartParkingBoy {

    private String errorMessage;

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {
        this.errorMessage = "";
        float maxPercentage = maxPercentageOfUseableVolume(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if ((parkingLot.getVolume() - parkingLot.getParkingRoom().size()) / (float) parkingLot.getVolume() == maxPercentage) {
                CarTicket carTicket = parkingLot.parkingCar(car);
                if (carTicket != null) {
                    return carTicket;
                }
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    @Override
    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetchCar(carTicket);
            if (car != null) {
                return car;
            }
            this.errorMessage = "Unrecognized parking ticket.";
        }
        return null;
    }

    private float maxPercentageOfUseableVolume(ArrayList<ParkingLot> parkingLots) {
        float max = 0;
        for (ParkingLot parkingLot : parkingLots) {
            int nullVolume = parkingLot.getVolume() - parkingLot.getParkingRoom().size();
            if (max < nullVolume / (float) parkingLot.getVolume()) {
                max = nullVolume / (float) parkingLot.getVolume();
            }
        }
        return max;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if (!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
