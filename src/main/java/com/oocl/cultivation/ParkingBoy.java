package com.oocl.cultivation;

public interface ParkingBoy {
    public CarTicket parkingCar(Car car);
    public Car fetchCar(CarTicket carTicket);
    public String answerCustomerMessage(CarTicket carTicket);
}
