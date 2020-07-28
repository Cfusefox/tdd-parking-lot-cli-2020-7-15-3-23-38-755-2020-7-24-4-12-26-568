package com.oocl.cultivation;


import java.util.Arrays;
import java.util.List;

public class ParkingLotManager {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    List<ParkingCarBehavior> parkingAbles;
    private String errorMessage;

    public ParkingLotManager(ParkingCarBehavior... parkingAbles) {
        this.parkingAbles = Arrays.asList(parkingAbles);
        this.errorMessage = "";
    }

    public CarTicket parkingCar(Car car) {
        CarTicket carTicket = this.parkingAbles.get(0).parkingCar(car);
        if(carTicket == null) {
            this.errorMessage = NOT_ENOUGH_POSITION;
        }
        return carTicket;

    }

    public Car fetchCar(CarTicket carTicket) {
        Car fetchCar = this.parkingAbles.get(0).fetchCar(carTicket);
        if(fetchCar == null) {
            this.errorMessage = UNRECOGNIZED_PARKING_TICKET;
        }
        return fetchCar;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if(!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return PLEASE_PROVIDE_YOUR_PARKING_TICKET;
        }
    }
}
