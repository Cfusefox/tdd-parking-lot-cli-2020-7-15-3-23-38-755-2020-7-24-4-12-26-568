package com.oocl.cultivation;


import java.util.LinkedHashMap;

public class ParkingLot implements ParkingCarBehavior {

    private static final int DEFAULT_VOLUME = 10;
    LinkedHashMap<CarTicket, Car> parkingRoom = new LinkedHashMap<>();
    private int volume;

    public ParkingLot(int volume) {
        this.volume = volume;
    }

    public ParkingLot() {
        this.volume = DEFAULT_VOLUME;
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
        this.parkingRoom.get(carTicket);
        return this.parkingRoom.remove(carTicket);
    }


}
