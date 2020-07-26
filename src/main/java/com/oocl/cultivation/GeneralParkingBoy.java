package com.oocl.cultivation;

import com.oocl.cultivation.ParkingCarBehavior.GeneralParkingCarBehavior;
import com.oocl.cultivation.ParkingCarBehavior.ParkingCarBehavior;

import java.util.ArrayList;

public class GeneralParkingBoy implements ParkingBoy{


    private final ArrayList<ParkingLot> parkingLots;
    private String errorMessage;
    private ParkingCarBehavior parkingCarBehavior;



    public GeneralParkingBoy(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLots = parkingLotList;
        this.errorMessage = null;
        this.parkingCarBehavior = new GeneralParkingCarBehavior();
    }

    public CarTicket parkingCar(Car car) {
        this.errorMessage = null;
        CarTicket carTicket = this.parkingCarBehavior.parkingCar(car, this.parkingLots);
        if(carTicket != null) {
            return carTicket;
        } else {
            this.errorMessage = "Not enough position.";
            return null;
        }

    }

    public Car fetchCar(CarTicket carTicket) {
        for (ParkingLot parkingLot: parkingLots) {
            Car car = parkingLot.fetch(carTicket);
            if(car != null) {
                return car;
            }
            this.errorMessage = parkingLot.getErrorMessage();
        }
        return null;
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        if(this.errorMessage != null) {
            return this.errorMessage;
        } else {
            return "Please provide your parking ticket.";
        }
    }

}
