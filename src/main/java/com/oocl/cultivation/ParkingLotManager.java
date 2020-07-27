package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkingLotManager {

    List<ParkingCarBehavior> parkingAbles;

    public ParkingLotManager(ParkingCarBehavior... parkingAbles) {
        this.parkingAbles = Arrays.asList(parkingAbles);
    }

    public CarTicket parkingCar(Car car) {
        return this.parkingAbles.get(0).parkingCar(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        return this.parkingAbles.get(0).fetchCar(carTicket);
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if(carTicket == null) {
            return "Not enough position.";
        } else {
            return "Unrecognized parking ticket.";
        }
    }
}
