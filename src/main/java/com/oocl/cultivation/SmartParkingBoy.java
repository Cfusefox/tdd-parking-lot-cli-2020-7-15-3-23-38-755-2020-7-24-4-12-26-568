package com.oocl.cultivation;


import java.util.ArrayList;

public class SmartParkingBoy extends GeneralParkingBoy {


    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {
        int maxNullVolume = maxVolumeNumber(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getVolume() - parkingLot.getParkingRoom().size() == maxNullVolume) {
                CarTicket carTicket = parkingLot.parkingCar(car);
                if (carTicket != null) {
                    return carTicket;
                }
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    private int maxVolumeNumber(ArrayList<ParkingLot> parkingLots) {
        final int[] max = {0};
        parkingLots.stream().forEach(parkingLot -> {
            int nullVolume = parkingLot.getVolume() - parkingLot.getParkingRoom().size();
            if (max[0] < nullVolume) {
                max[0] = nullVolume;
            }
        });
        return max[0];
    }



}
