package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkingLotManager {

    List<ParkingCarBehavior> parkingAbles;
    private String errorMessage;

    public ParkingLotManager(ParkingCarBehavior... parkingAbles) {
        this.parkingAbles = Arrays.asList(parkingAbles);
        this.errorMessage = "";
    }

    public CarTicket parkingCar(Car car) {
        CarTicket carTicket = this.parkingAbles.get(0).parkingCar(car);
        if(carTicket == null) {
            this.errorMessage = "Not enough position.";
        }
        return carTicket;

    }

    public Car fetchCar(CarTicket carTicket) {
        Car fetchCar = this.parkingAbles.get(0).fetchCar(carTicket);
        if(fetchCar == null) {
            this.errorMessage = "Unrecognized parking ticket.";
        }
        return fetchCar;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if(!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }
}
