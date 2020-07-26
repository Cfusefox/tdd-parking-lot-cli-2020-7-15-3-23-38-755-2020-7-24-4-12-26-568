package com.oocl.cultivation;

import com.oocl.cultivation.ParkingCarBehavior.GeneralParkingCarBehavior;
import com.oocl.cultivation.ParkingCarBehavior.ParkingCarBehavior;

import java.util.ArrayList;

public class ParkingLotManager {

    private ArrayList<ParkingLot> parkingLots;
    private ArrayList<ParkingBoy> parkingBoys;
    private ParkingCarBehavior parkingCarBehavior;

    public ParkingLotManager(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingBoys = new ArrayList<>();
        this.parkingCarBehavior = new GeneralParkingCarBehavior();
    }

    public boolean addParkingBoy(ParkingBoy parkingBoy) {
        return this.parkingBoys.add(parkingBoy);
    }

    public CarTicket letParkingBoyParkingCar(Car car) {
        ParkingBoy parkingBoy = this.parkingBoys.get(0);
        return parkingBoy.parkingCar(car);
    }

    public Car letParkingBoyFetchCar(CarTicket carTicket) {
        ParkingBoy parkingBoy = this.parkingBoys.get(0);
        return parkingBoy.fetchCar(carTicket);
    }

    public CarTicket parkingCar(Car car) {
        return this.parkingCarBehavior.parkingCar(car, this.parkingLots);
    }

    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot: parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if(car != null) {
                return car;
            }
        }
        return null;
    }
}
