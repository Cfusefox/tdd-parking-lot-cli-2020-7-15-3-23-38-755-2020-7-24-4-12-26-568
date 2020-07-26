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
        return true;
    }
}
