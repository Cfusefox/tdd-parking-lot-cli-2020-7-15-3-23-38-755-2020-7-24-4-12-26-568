package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkingLotManager {

    List<ParkingCarBehavior> parkingAbles;

    public ParkingLotManager(ParkingCarBehavior... parkingAbles) {
        this.parkingAbles = Arrays.asList(parkingAbles);
    }

    public boolean addParkingBoy(ParkingCarBehavior parkingBoy) {
        return this.parkingAbles.add(parkingBoy);
    }



    public CarTicket parkingCar(Car car) {
        return this.parkingAbles.get(0).parkingCar(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        return null;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        return null;
    }
}
