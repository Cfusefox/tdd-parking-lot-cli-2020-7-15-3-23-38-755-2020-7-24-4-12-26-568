package com.oocl.cultivation;


import java.util.LinkedHashMap;

public class ParkingLot implements ParkingCarBehavior {

    private String errorMessage;
    LinkedHashMap<CarTicket, Car> parkingRoom = new LinkedHashMap<>();
    private int volume;
    private int availableLocations;

    public ParkingLot(int volume) {
        this.volume = volume;
        this.errorMessage = "";
    }

    public ParkingLot() {
        this.volume = 10;
        this.errorMessage = "";
    }

    public int getAvailableLocations() {
        return this.volume - this.parkingRoom.size();
    }

    public float getAvailablePercentage() {
        return (this.volume - this.parkingRoom.size()) / (float)this.volume;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public CarTicket parkingCar(Car car) {
        if (parkingRoom.size() >= this.volume) {
            this.errorMessage = "Not enough position.";
            return null;
        }
        CarTicket carTicket = new CarTicket(car);
        this.parkingRoom.put(carTicket, car);
        return carTicket;
    }

    public LinkedHashMap<CarTicket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public Car fetchCar(CarTicket carTicket) {
        if (this.parkingRoom.get(carTicket) == null) {
            this.errorMessage = "Unrecognized parking ticket.";
        }
        return this.parkingRoom.remove(carTicket);
    }


}
