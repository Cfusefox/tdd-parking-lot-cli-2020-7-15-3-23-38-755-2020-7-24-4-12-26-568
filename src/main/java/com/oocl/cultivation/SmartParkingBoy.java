package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartParkingBoy extends GeneralParkingBoy {


    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {

        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailableLocations));
        if (optionalParkingLot.isPresent()) {
            if (optionalParkingLot.get().getAvailableLocations() > 0) {
                this.errorMessage = "Not enough position.";
            }
        }
        return optionalParkingLot.map(parkingLot -> parkingLot.parkingCar(car)).orElse(null);


    }
}
