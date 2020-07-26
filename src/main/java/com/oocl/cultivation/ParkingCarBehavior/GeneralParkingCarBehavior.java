package com.oocl.cultivation.ParkingCarBehavior;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.ArrayList;

public class GeneralParkingCarBehavior implements ParkingCarBehavior{

    @Override
    public CarTicket parkingCar(Car car, ArrayList<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot: parkingLots) {
            CarTicket carTicket = parkingLot.park(car);
            if(carTicket != null) {
                return carTicket;
            }
        }
        return null;
    }
}
