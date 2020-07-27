package com.oocl.cultivation;


import java.util.ArrayList;

public class GeneralParkingBoy implements ParkingCarBehavior {


    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;


    public GeneralParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
        this.errorMessage = "";
    }

    public CarTicket parkingCar(Car car) {
        this.errorMessage = "";
        for (ParkingLot parkingLot : parkingLots) {
            CarTicket carTicket = parkingLot.park(car);
            if (carTicket != null) {
                return carTicket;
            }
        }
        this.errorMessage = "Not enough position.";
        return null;
    }

    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if (car != null) {
                return car;
            }
            this.errorMessage = parkingLot.getErrorMessage();
        }
        return null;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if (!this.errorMessage.equals("")) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
