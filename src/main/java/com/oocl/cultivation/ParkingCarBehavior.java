package com.oocl.cultivation;


public interface ParkingCarBehavior {
    public CarTicket parkingCar(Car car);
    public Car fetchCar(CarTicket carTicket);
}
