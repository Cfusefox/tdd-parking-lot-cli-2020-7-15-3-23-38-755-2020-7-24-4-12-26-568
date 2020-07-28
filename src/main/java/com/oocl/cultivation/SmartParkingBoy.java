package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends GeneralParkingBoy {


    private static final String NOT_ENOUGH_POSITION = "Not enough position.";

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {

        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableLocations));
        if (optionalParkingLot.isPresent()) {
            if (optionalParkingLot.get().getAvailableLocations() > 0) {
                this.errorMessage = NOT_ENOUGH_POSITION;
            }
        }
        return optionalParkingLot.map(parkingLot -> parkingLot.parkingCar(car)).orElse(null);


    }
}
