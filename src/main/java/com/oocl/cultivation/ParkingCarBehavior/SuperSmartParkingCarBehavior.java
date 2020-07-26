package com.oocl.cultivation.ParkingCarBehavior;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.ArrayList;

public class SuperSmartParkingCarBehavior implements ParkingCarBehavior{

    @Override
    public CarTicket parkingCar(Car car, ArrayList<ParkingLot> parkingLots) {
        float maxPercentage = maxPercentageOfUseableVolume(parkingLots);
        for (ParkingLot parkingLot: parkingLots) {
            if((parkingLot.getVolume() - parkingLot.getParkingRoom().size()) / (float) parkingLot.getVolume()  == maxPercentage) {
                CarTicket carTicket = parkingLot.park(car);
                if(carTicket != null) {
                    return carTicket;
                }
            }
        }
        return null;
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
