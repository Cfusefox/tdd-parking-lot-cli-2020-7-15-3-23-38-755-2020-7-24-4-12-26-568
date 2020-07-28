package com.oocl.cultivation;


import java.util.LinkedHashMap;

public class ParkingLot implements ParkingCarBehavior {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private static final int DEFAULT_VOLUE = 10;
    private String errorMessage;
    LinkedHashMap<CarTicket, Car> parkingRoom = new LinkedHashMap<>();
    private int volume;
    private int availableLocations;

    public ParkingLot(int volume) {
        this.volume = volume;
        this.errorMessage = "";
    }

    public ParkingLot() {
        this.volume = DEFAULT_VOLUE;
        this.errorMessage = "";
    }

    public int getAvailableLocations() {
        return this.volume - this.parkingRoom.size();
    }

    public float getAvailablePercentage() {
        return (this.volume - this.parkingRoom.size()) / (float) this.volume;
    }


    @Override
    public CarTicket parkingCar(Car car) {
        if (parkingRoom.size() >= this.volume) {
            this.errorMessage = NOT_ENOUGH_POSITION;
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
            this.errorMessage = UNRECOGNIZED_PARKING_TICKET;
        }
        return this.parkingRoom.remove(carTicket);
    }


}
