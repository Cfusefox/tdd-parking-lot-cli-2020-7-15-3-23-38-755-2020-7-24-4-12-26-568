package com.oocl.cultivation;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
        this.parkingLot = new ParkingLot();
    }

    public CarTicket parkingCar(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetchCar(CarTicket carTicket) {
        return carTicket == null ? null : this.parkingLot.fetch(carTicket);
    }

    public String answerCustomerMessage(CarTicket carTicket) {
        return this.parkingLot.checkCarTicketIsValid(carTicket);
    }

}
