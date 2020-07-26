package com.oocl.cultivation.ParkingCarBehavior;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.ArrayList;

public class SmartParkingCarBehavior implements ParkingCarBehavior{
    @Override
    public CarTicket parkingCar(Car car, ArrayList<ParkingLot> parkingLots) {
        int maxNullVolume = maxVolumeNumber(parkingLots);
        for (ParkingLot parkingLot: parkingLots) {
            if(parkingLot.getVolume() - parkingLot.getParkingRoom().size() == maxNullVolume) {
                CarTicket carTicket = parkingLot.park(car);
                if(carTicket != null) {
                    return carTicket;
                }
            }
        }
        return null;
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
