package com.oocl.cultivation.ParkingCarBehavior;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;

import java.util.ArrayList;

public interface ParkingCarBehavior {
    public CarTicket parkingCar(Car car, ArrayList<ParkingLot> parkingLots);
}
