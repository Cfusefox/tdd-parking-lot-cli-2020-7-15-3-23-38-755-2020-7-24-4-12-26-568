package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class SuperSmartParkingBoy extends SmartParkingBoy {


    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
        this.errorMessage = "";
    }

    @Override
    public CarTicket parkingCar(Car car) {
        Optional<ParkingLot> optionalParkingLot = parkingLots.stream().max(Comparator.comparing(ParkingLot::getAvailablePercentage));
        if (optionalParkingLot.isPresent()) {
            if (optionalParkingLot.get().getAvailableLocations() > 0) {
                this.errorMessage = "Not enough position.";
            }
        }
        return optionalParkingLot.map(parkingLot -> parkingLot.parkingCar(car)).orElse(null);
    }


}
