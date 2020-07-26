package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingLotManager {

    private ArrayList<ParkingLot> parkingLots;
    private ArrayList<ParkingBoy> parkingBoys;

    public ParkingLotManager(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.parkingBoys = new ArrayList<>();
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
}
