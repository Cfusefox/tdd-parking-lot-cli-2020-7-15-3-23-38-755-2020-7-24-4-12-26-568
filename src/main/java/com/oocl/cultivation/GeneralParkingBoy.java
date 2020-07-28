package com.oocl.cultivation;


import java.util.ArrayList;

public class GeneralParkingBoy implements ParkingCarBehavior {


    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    protected final ArrayList<ParkingLot> parkingLots;
    protected String errorMessage;


    public GeneralParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
        this.errorMessage = "";
    }

    public CarTicket parkingCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            CarTicket carTicket = parkingLot.parkingCar(car);
            if (carTicket != null) {
                return carTicket;
            }
        }
        this.errorMessage = NOT_ENOUGH_POSITION;
        return null;
    }

    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetchCar(carTicket);
            if (car != null) {
                return car;
            }
            this.errorMessage = UNRECOGNIZED_PARKING_TICKET;
        }
        return null;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if (!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return PLEASE_PROVIDE_YOUR_PARKING_TICKET;
        }
    }

}
