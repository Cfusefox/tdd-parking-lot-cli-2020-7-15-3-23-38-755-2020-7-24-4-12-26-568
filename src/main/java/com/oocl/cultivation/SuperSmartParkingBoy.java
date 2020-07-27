package com.oocl.cultivation;


import java.util.ArrayList;

public class SuperSmartParkingBoy extends SmartParkingBoy {

    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {
        this.errorMessage = "";
        float maxPercentage = maxPercentageOfUseableVolume(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if ((parkingLot.getVolume() - parkingLot.getParkingRoom().size()) / (float) parkingLot.getVolume() == maxPercentage) {
                CarTicket carTicket = parkingLot.park(car);
                if (carTicket != null) {
                    return carTicket;
                }
            }
        }
        this.errorMessage = "Not enough position.";
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

}
