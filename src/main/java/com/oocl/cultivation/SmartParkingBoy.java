package com.oocl.cultivation;


import java.util.ArrayList;

public class SmartParkingBoy extends GeneralParkingBoy {


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



}
